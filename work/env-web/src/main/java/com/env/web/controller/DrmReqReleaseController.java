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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.commons.utils.StringUtils;
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
import com.env.util.MobileValidateCodeUtil;
import com.env.util.bean.MobileValidateCodeCheckResult;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(DrmReqReleaseController.class);

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
				try{
					// 发邮件
					MailSender mailSender = new MailSender();
					for(String email : receiveUserEmails){
						// 验证addr是否是email
						LOGGER.debug("收件人邮箱地址"+email);
						if(StringUtils.checkEmail(email)){
							LOGGER.debug("发送邮件"+email);
							String un = (user==null)?"":(user.getNickname()==null)?"":user.getNickname();
							mailSender.sendMail("好职客用户有偿咨询服务请求", 
									"<h1>尊敬的好职客用户，您好；</h1><br/><h3>    好职客用户:"+un+"  向您咨询["
										+req.getCompanyShotname()+"]的情况，愿向您支付诚意金["+req.getPrice()+"元]，请访问<a href=\"http://www.haozhike.cn\">好职客 www.haozhike.cn</a> 接单！</h3><br/><br/><h2>感谢在成长的道路上有您的帮助和指导！</h2>", 
										email, "发布需求第一步", null, null, null, null);
						}
					}
				}catch(Exception e){
					LOGGER.error("邮件发送异常！"+e.getMessage());
					e.printStackTrace();
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
	public String first(HttpServletRequest request) {
//    	request.setAttribute("req_companyname", request.getSession().getAttribute("req_companyname"));
//    	request.getSession().removeAttribute("req_companyname");
    	String name="";
    	try {
    		if(null!=request.getParameter("name")){
    			name = new String(request.getParameter("name").getBytes("iso-8859-1"),"UTF-8");
    		}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	request.setAttribute("req_companyname" , name);
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
    
    
    

    /**
     * 手机验证码校验
     * @param request
     * @param session
     * @return
     */
	@RequestMapping(value = "/checkcode", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public Map<String, Object> checkRegisterPhoneCode(HttpServletRequest request, HttpSession session) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	String authCode = request.getParameter("authCode");
    	 
    	map.put("result", true);
    	 if (StringUtils.isNotBlank(authCode)) {
    		 MobileValidateCodeCheckResult result = MobileValidateCodeUtil.checkMobileValidateCode(session, authCode);
    		 if (!result.isCheckStatus()) {
    			 map.put("result", false);
    			 map.put("message", result.getCheckMessage());
    			 return map;
    		 }
    	 } else {
    		 map.put("result", false);
    		 map.put("message", "手机验证码为空");
    		 return map;
    	 }
    	 return map;
    }
}
