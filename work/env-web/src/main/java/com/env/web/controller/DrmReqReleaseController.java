/**
 * Description: 控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:47
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-22   caoyx   1.0         Initial
 */
package com.env.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.constant.Constants;
import com.env.dto.DrmCompany;
import com.env.dto.DrmReq;
import com.env.dto.DrmReqNotice;
import com.env.dto.DrmSearchCompany;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmCompanyService;
import com.env.service.intf.IDrmReqNoticeService;
import com.env.service.intf.IDrmReqService;
import com.env.service.intf.IDrmSearchCompanyService;
import com.env.service.intf.IPtUserService;
import com.env.web.util.MailSender;


/**
 * 需求发布五部曲<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-29
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/release")
public class DrmReqReleaseController extends BaseController {

	/**
	 * 自动注入用户注册的部门信息业务层实现
	 */
	@Autowired
	private IDrmReqService<DrmReq> drmReqService;


	@Autowired
	private IPtUserService<PtUser> ptUserService;

	@Autowired
	private IDrmReqNoticeService<DrmReqNotice> drmReqNoticeService;

	@Autowired
	private IDrmCompanyService<DrmCompany> drmCompanyService;

	@Autowired
	private IDrmSearchCompanyService<DrmSearchCompany> drmSearchCompanyService;
	
	/**
	 * 涉及到的表：pt_user,drm_req,drm_company,drm_search_company,drm_req_notice
	 * @param req
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "release1_save")
	public String save (DrmReq req,HttpServletRequest request){
		try{
			Integer curUserId = null;
			String telephone = null;
			PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
			if(null==user){
				
				// 未登录
				telephone = request.getParameter("telephone");
				String phonecode = request.getParameter("phonecode");
				
				// TODO  1/验证手机验证码
				
				// 2/判断当前手机号有没有注册账号：
				// a如果没有注册账号，新增user
				// b如果有注册账号，则查询他的userid
				user = new PtUser();
				user.setLoginId(telephone);// 根据登录号或者手机号查询是否存在注册账号
				user.setPhone(telephone);
				// TODO 新增用户成功，发送短信告知账号及登录密码
				
				// 判断该手机号是否已经注册过了
				List<PtUser> users = ptUserService.queryAllByParams(user);
				if(null==users || users.size()==0){
					// 未注册过了
					user.setPwd(telephone);// 登录密码默认手机号
					curUserId = ptUserService.save(user);
				}else{
					// 已经注册过了;  但未登录
					user = users.get(0);
					curUserId = user.getId();
					telephone = user.getPhone();
				}

			}else{
				// 已经登录
				curUserId = user.getId();
				telephone = user.getPhone();
			}
			
			// 3/save drm_req 保存需求
			req.setSendUserId(curUserId);
			req.setSendUserPhone(telephone);
			req.setSendUserNickname((user==null)?"":user.getNickname());
			req.setAcceptState(0);//应答状态0未应答1已应答2赏金已托管3服务已完成4申请退款5放弃需求
			Integer reqId = drmReqService.save(req);

			// 4/query drm_company 匹配
			DrmCompany company = new DrmCompany();
			company.setCompanyName(req.getCompanyShotname());
			company.setCompanyShotname(req.getCompanyShotname());
			List<DrmCompany> companys = drmCompanyService.queryAllByParams(company);
			
			// 5/用户发布的公司需求，要把公司名称记录下来 drm_search_company  --------------begin
			DrmSearchCompany sc = new DrmSearchCompany();
			sc.setCompanyName(req.getCompanyShotname());
			sc.setCompanyShotname(req.getCompanyShotname());
			sc.setFlag(1);
			sc.setSendUserId(curUserId);
			sc.setSendUserPhone(telephone);
			sc.setSearched(0);// 先赋个初始值0，标志未匹配到
			
			// 保存匹配到的用户id集合
			List<Integer> receiveUserIds = new ArrayList<Integer>();
			
			// 如果查询到, save drm_req_notice
			if(null!=companys && companys.size()>0){
				DrmReqNotice notice = new DrmReqNotice();
				notice.setSendUserId(curUserId);
				notice.setReqId(reqId);
				for(DrmCompany c : companys){// 匹配到1-N个用户
					if(curUserId.compareTo(c.getUserId()) != 0){
						// 如果匹配到自身，则忽略
						receiveUserIds.add(c.getUserId());
						notice.setReceiveUserId(c.getUserId());
						drmReqNoticeService.save(notice);
						sc.setSearched(1);//匹配到
					}
				}
			}
			drmSearchCompanyService.save(sc);
			// 用户发布的公司需求，要把公司名称记录下来 drm_search_company  --------------end
			
			// 根据是否匹配到，给前端反馈
			if(sc.getSearched().intValue()==1){
				// 匹配到
				
				// 保存 匹配到的用户电话集合
				List<String> receiveUserPhones = new ArrayList<String>();
				// 保存 匹配到的用户邮箱集合
				List<String> receiveUserEmails = new ArrayList<String>();
				for(Integer receiveUserId : receiveUserIds){
					PtUser u = ptUserService.getById(receiveUserId);// 查询匹配到的用户
					receiveUserPhones.add((u==null)?"":u.getPhone());
					receiveUserEmails.add((u==null)?"":u.getEmail());
				}
				
				// TODO  6/发布成功，发送短信/发邮件
				// 发邮件
				MailSender mailSender = new MailSender();
				for(String addr : receiveUserEmails){
					mailSender.sendMail("好职客用户有偿咨询服务请求", 
							"尊敬的客户，您好；\n好职客用户"+((user==null)?"":user.getNickname())+"向您咨询["
								+req.getCompanyShotname()+"]的情况，愿向您支付诚意金+["+req.getPrice()+"]请登录www.haozhike.cn接单！\n其实您可以帮助更多的人，感谢在我的道路上有您的指导！", 
					addr, "发布需求第一步", null, null, null, null);
				}
				
				
				request.getSession().setAttribute("match_success", 1);// 匹配成功标志
			}else{
				// 未匹配到
				request.getSession().setAttribute("match_success", 0);// 匹配失败标志
			}
			
			
			request.getSession().setAttribute("match_user_count", receiveUserIds.size());// 匹配到的用户数
			request.getSession().setAttribute("req_company_shotname", req.getCompanyShotname());// 目标公司名称
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/release/second";
	}

	

    @RequestMapping(value="first")
	public String first(){
		return "drmreqrelease/pages/release1";
	}

    @RequestMapping(value="second")
	public String second(HttpServletRequest request){

		request.setAttribute("match_user_count", request.getSession().getAttribute("match_user_count"));// 匹配到的用户数
		request.setAttribute("match_success", request.getSession().getAttribute("match_success"));//1匹配成功，0匹配不成功
		request.setAttribute("req_company_shotname", request.getSession().getAttribute("req_company_shotname"));//目标公司
		
		request.getSession().removeAttribute("match_user_count");
		request.getSession().removeAttribute("match_success");
		request.getSession().removeAttribute("req_company_shotname");
		
		return "drmreqrelease/pages/release2";
	}

    @RequestMapping(value="third")
	public String third(){
		return "drmreqrelease/pages/release3";
	}

    @RequestMapping(value="forth")
	public String forth(){
		return "drmreqrelease/pages/release4";
	}

    @RequestMapping(value="fifth")
	public String fifth(){
		return "drmreqrelease/pages/release5";
	}
    
}
