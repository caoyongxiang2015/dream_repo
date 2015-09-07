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

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.constant.Constants;
import com.env.dao.api.Page;
import com.env.dao.api.QueryParams;
import com.env.dto.DrmReq;
import com.env.dto.DrmReqNotice;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmReqNoticeService;
import com.env.service.intf.IDrmReqService;
import com.env.vo.DrmReqVo;


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
	private IDrmReqService drmReqService;

	@Autowired
	private IDrmReqNoticeService<DrmReqNotice> drmReqNoticeService;

    @RequestMapping()
	public String index(HttpServletRequest request){
    	
    	PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
    	
    	
    	// ================ 我收到的需求 ====================
    	DrmReqNotice notice = new DrmReqNotice();
    	
    	notice.setReceiveUserId((user==null)?0:user.getId());
    	// TODO 
    	// 1 drm_req_notice  我接收到的需求
    	// 2 drm_req 需求的信息：如金额，公司名称
    	List<DrmReqNotice> notices = drmReqNoticeService.queryByParams(notice);
    	
    	
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
    	List<DrmReq>  reqs = drmReqService.queryByParams(req);
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
	 * 修改需求
	 * 
	 * @param drmReqVo 需求页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmReqVo drmReqVo){
		try{
			drmReqService.update(drmReqVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmreq/detail/"+ drmReqVo.getEntity().getId();
	}

}
