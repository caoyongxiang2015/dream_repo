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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.dto.DrmCompany;
import com.env.dto.DrmReq;
import com.env.dto.DrmReqNotice;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmCompanyService;
import com.env.service.intf.IDrmReqNoticeService;
import com.env.service.intf.IDrmReqService;
import com.env.service.intf.IPtUserService;


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
	
	@RequestMapping(value = "release1_save")
	public String save (DrmReq req,HttpServletRequest request){
		try{
			String telephone = request.getParameter("telephone");
			String phonecode = request.getParameter("phonecode");
			
			// TODO 
			// 1/验证手机验证码
			
			// 2/判断当前手机号有没有注册账号：
			// a如果没有注册账号，新增user
			// b如果有注册账号，则查询他的userid
			PtUser user = new PtUser();
			user.setLoginId(telephone);// 根据登录号或者手机号查询是否存在注册账号
			user.setPhone(telephone);
			List<PtUser> users = ptUserService.queryAllByParams(user);
			Integer userId = null;
			if(null==users || users.size()==0){
				user.setPwd(telephone);// 登录密码默认手机号
				userId = ptUserService.save(user);
			}else{
				user = users.get(0);
				userId = user.getId();
			}
			
			// 3/save drm_req
			Integer reqId = -1;
			reqId = drmReqService.save(req);

			// 4/query drm_company
			DrmCompany company = new DrmCompany();
			company.setCompanyName(req.getCompanyShotname());
			company.setCompanyShotname(req.getCompanyShotname());
			List<DrmCompany> companys = drmCompanyService.queryAllByParams(company);
			
			// 如果查询到, save drm_req_notice
			if(null!=companys && companys.size()>0){
				DrmReqNotice notice = new DrmReqNotice();
				notice.setSendUserId(userId);
				notice.setReqId(reqId);
				for(DrmCompany c : companys){// 匹配到1-N个用户
					if(userId.compareTo(c.getUserId()) != 0){
						// 如果匹配到自身，则忽略
						notice.setReceiveUserId(c.getUserId());
						drmReqNoticeService.save(notice);
					}
				}
			}
			// 5/发布成功，发送短信
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/release/second";
	}

	

    @RequestMapping(value="first")
	public String first(){
		return "drmreqrelease/pages/release1";
	}

    @RequestMapping(value="second")
	public String second(){
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
