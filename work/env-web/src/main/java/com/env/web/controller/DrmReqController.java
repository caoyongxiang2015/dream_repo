/**
 * Description: 需求控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:49
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-22   caoyx   1.0         Initial
 */
package com.env.web.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.constant.Constants;
import com.env.dto.DrmPayNotice;
import com.env.dto.DrmReq;
import com.env.dto.DrmReqNotice;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmPayNoticeService;
import com.env.service.intf.IDrmReqNoticeService;
import com.env.service.intf.IDrmReqService;
import com.env.service.intf.IPtUserService;
import com.env.util.D1SmsSender;
import com.env.vo.DrmReqVo;
import com.env.web.util.MailSender;


/**
 * 需求控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmreq")
public class DrmReqController extends BaseController {

	/**
	 * 自动注入需求业务层实现
	 */

    @Autowired
//    private SmsSender smsSender;
	private D1SmsSender smsSender;

	@Autowired
	private IPtUserService<PtUser> ptUserService;
	
	@Autowired
	private IDrmReqService<DrmReq> drmReqService;

	@Autowired
	private IDrmReqNoticeService<DrmReqNotice> drmReqNoticeService;
	@Autowired
	private IDrmPayNoticeService<DrmPayNotice> drmPayNoticeService;

    @RequestMapping()
	public String index(HttpServletRequest request){
    	
    	PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
    	
    	
    	// ================ 我收到的需求 ====================
    	DrmReqNotice notice = new DrmReqNotice();
    	
    	notice.setReceiveUserId((user==null)?0:user.getId());
    	// TODO 
    	// 1 drm_req_notice  我接收到的需求
    	// 2 drm_req 需求的信息：如金额，公司名称
    	List<DrmReqNotice> tempNotices = drmReqNoticeService.queryByParams(notice);
    	List<DrmReqNotice> notices = new ArrayList<DrmReqNotice> ();
    	
    	//未被应答，或者该需求是当前登录用户应答的
    	for(DrmReqNotice n : tempNotices){
    		DrmReq r = n.getReq();
    		if(r!=null&&r.getAcceptState()!=null){
	    		if(r.getAcceptState().intValue()==0 || r.getAcceptUserId().intValue()==user.getId().intValue()){
	    			notices.add(n);
	    		}
    		}
    	}
    	
    	// 3 私信
    	// 4
    	
    	
    	request.setAttribute("cur_userid", user.getId());
    	request.setAttribute("notices", notices);
    	// accept_success:0已经被抢先应答,1应答成功,-1应答异常失败,2本人已应答过
    	request.setAttribute("accept_success", request.getSession().getAttribute("accept_success"));
    	
    	request.getSession().removeAttribute("accept_success");
    	
    	

    	// ================ 我发出的需求 ====================
    	DrmReq req = new DrmReq();
    	req.setSendUserId(user.getId());
    	List<DrmReq>  tempreqs = drmReqService.queryByParams(req);
    	List<DrmReq>  reqs = new ArrayList<DrmReq>();
    	
    	for(DrmReq r : tempreqs){
    		PtUser u = ptUserService.getById(r.getAcceptUserId());// 获取应答者的信息
    		if(r.getAcceptState().intValue()==2){// 2赏金已托管3服务已完成
    			r.setAcceptUser(u);
    		}
    		reqs.add(r);
    	}
    	
    	request.setAttribute("reqs", reqs);
    	
    	
		return "drmreq/pages/req";
	}


	/**
	 * 接受需求
	 * @param reqId 需求id
	 * @return
	 */
	@RequestMapping(value = "receive")
	public String receive(DrmReqVo drmReqVo,HttpServletRequest request){
		
		// 先判断是否已经被其他用户接收请求了。
		PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
		DrmReq old = (DrmReq)drmReqService.getById(drmReqVo.getEntity().getId());
		if(old.getAcceptState().intValue()==1){
			// 已经是‘已应答状态’
			if(old.getAcceptUserId().intValue() == user.getId().intValue()){
				request.getSession().setAttribute("accept_success", 2);// 本人已应答过
			}else{
				request.getSession().setAttribute("accept_success", 0);// 已经被抢先应答
			}
			return "redirect:/drmreq";
		}
		
		try{
			
			Calendar cal = Calendar.getInstance();
			
			old.setAcceptDuration(drmReqVo.getEntity().getAcceptDuration());
			old.setAcceptState(drmReqVo.getEntity().getAcceptState());
			old.setAcceptTime(cal.getTime());
			old.setAcceptUserId(user.getId());
			old.setOpenContact(drmReqVo.getEntity().getOpenContact());
			drmReqService.update(old);
			request.getSession().setAttribute("accept_success",1);// 应答成功
		}catch(Exception e){
			request.getSession().setAttribute("accept_success",-1);// 应答失败
		}
		
		
		return "redirect:/drmreq";
	}
	

	/**
	 * 放弃帮助
	 * @param drmReqVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "giveupHelp")
	public String giveupHelp (HttpServletRequest request){
		try{
			Integer reqid = Integer.valueOf(request.getParameter("reqid"));
			DrmReq old = (DrmReq)drmReqService.getById(reqid);
			
			Integer acceptstate = Integer.valueOf(request.getParameter("acceptstate"));
//			request.getParameter("completetime");
//			request.getParameter("stoptime");
//			request.getParameter("endtime");
			Calendar cal = Calendar.getInstance();
			
			old.setAcceptState(acceptstate);//应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求6确认将赏金转给对方7重新发起需求
//			old.setCompleteTime(entity.getCompleteTime());//服务完成时间
			old.setStopTime(cal.getTime());//废弃终止时间
//			old.setEndTime(entity.getEndTime());//评价结束时间
			
			drmReqService.update(old);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "-1";
		}
		return "1";
	}
	
	/**
	 * 申请退款
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "backMoney")
	public String backMoney (HttpServletRequest request){
		try{
			Integer reqid = Integer.valueOf(request.getParameter("reqid"));
			DrmReq old = (DrmReq)drmReqService.getById(reqid);
			
			Integer acceptstate = Integer.valueOf(request.getParameter("acceptstate"));
			Calendar cal = Calendar.getInstance();
			
			old.setAcceptState(acceptstate);//应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求6确认将赏金转给对方7重新发起需求
			old.setApplyBackmoneyTime(cal.getTime());//申请退款时间
			
			drmReqService.update(old);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "-1";
		}
		return "1";
	}
	
	/**
	 * 服务完成
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "serviceComplete")
	public String serviceComplete (HttpServletRequest request){
		try{
			Integer reqid = Integer.valueOf(request.getParameter("reqid"));
			DrmReq old = (DrmReq)drmReqService.getById(reqid);
			
			Integer acceptstate = Integer.valueOf(request.getParameter("acceptstate"));
			Calendar cal = Calendar.getInstance();
			
			old.setAcceptState(acceptstate);//应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求
			old.setCompleteTime(cal.getTime());//服务完成时间
			
			drmReqService.update(old);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "-1";
		}
		return "1";
	}
	
	/**
	 * 确认付款给对方
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "payComplete")
	public String payComplete (HttpServletRequest request){
		try{
			Integer reqid = Integer.valueOf(request.getParameter("reqid"));
			DrmReq old = (DrmReq)drmReqService.getById(reqid);
			
			Integer acceptstate = Integer.valueOf(request.getParameter("acceptstate"));
			Calendar cal = Calendar.getInstance();
			
			old.setAcceptState(acceptstate);//应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求6确认将赏金转给对方7重新发起需求
			old.setPayTime(cal.getTime());//确认付款给对方时间
			
			drmReqService.update(old);

			// 赏金托管-付款通知  drm_pay_notice
			DrmPayNotice pn = new DrmPayNotice();
			pn.setReqId(reqid);
			pn.setCompanyName(old.getCompanyShotname());
			pn.setMoney(old.getPrice());
			pn.setReceiveUserId(old.getAcceptUserId());
			pn.setNoticeType(2);//通知类型：1赏金托管完成通知，2服务完成确认付款通知
			pn.setUserId(old.getSendUserId());
			pn.setUserPhone(old.getSendUserPhone());
			
			drmPayNoticeService.save(pn);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "-1";
		}
		return "1";
	}
	/**
	 * 赏金托管完成
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "depositMoney")
	public String depositMoney (HttpServletRequest request){
		try{
			Integer reqid = Integer.valueOf(request.getParameter("reqid"));
			DrmReq old = (DrmReq)drmReqService.getById(reqid);
			
			Integer acceptstate = Integer.valueOf(request.getParameter("acceptstate"));
			Calendar cal = Calendar.getInstance();
			
			old.setAcceptState(acceptstate);//应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求6确认将赏金转给对方7重新发起需求
			old.setDepositTime(cal.getTime());//2赏金已托管
			
//			drmReqService.update(old);// 需要客服确认后才能更改状态
			
			// 赏金托管-付款通知  drm_pay_notice
			DrmPayNotice pn = new DrmPayNotice();
			pn.setReqId(reqid);
			pn.setCompanyName(old.getCompanyShotname());
			pn.setMoney(old.getPrice());
			pn.setReceiveUserId(old.getAcceptUserId());
			pn.setNoticeType(1);//通知类型：1赏金托管完成通知，2服务完成确认付款通知
			pn.setUserId(old.getSendUserId());
			pn.setUserPhone(old.getSendUserPhone());
			
			drmPayNoticeService.save(pn);

			// 邮件通知好职客
			MailSender mailSender = new MailSender();
			mailSender.sendMail("[好职客]提醒：诚意金托管完成通知,托管人id="+old.getSendUserId()+",reqid="+reqid, "", "haozhike@yeah.net", "需求-资金托管完成通知客服", null, null, null, null);
			
			// 短信通知
			//smsSender.sendSms(D1SmsSender.CUSTOMER_PHONE, "提醒:资金托管通知reqid="+reqid+",托管人id="+old.getSendUserId());
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "-1";
		}
		return "1";
	}
	
	/**
	 * 重新发起需求
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "againRelease")
	public String againRelease (HttpServletRequest request){
		String name = "";
		try{
			Integer reqid = Integer.valueOf(request.getParameter("reqid"));
			DrmReq old = (DrmReq)drmReqService.getById(reqid);
			
			Calendar cal = Calendar.getInstance();
			
			name = old.getCompanyShotname();
			old.setAcceptState(7);//应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求6确认将赏金转给对方7重新发起需求
			old.setAgainReleaseTime(cal.getTime());//重新发起需求时间
			
			drmReqService.update(old);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "-1";
		}
		return "redirect:/release/first?name="+name;
	}
	

	@ResponseBody
	@RequestMapping(value="/tip/{reqid}", method=RequestMethod.POST ,produces = "application/json; charset=utf-8")  
	public String tip (@PathVariable("reqid") Integer reqid, HttpServletRequest request){
		DrmReq old = drmReqService.getById(reqid);
    	old.setTipCount(old.getTipCount()+1);;
    	drmReqService.update(old);
		return "1";
	}
}
