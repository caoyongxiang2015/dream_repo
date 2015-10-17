/**
 * Description: 用户注册的公司信息控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:45
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.commons.utils.StringUtils;
import com.env.constant.Constants;
import com.env.dto.DrmCompany;
import com.env.dto.DrmCompanyLib;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmCompanyLibService;
import com.env.service.intf.IDrmCompanyService;
import com.env.service.intf.IPtUserService;
import com.env.vo.DrmCompanyVo;
import com.env.web.util.MailSender;


/**
 * 用户注册的公司信息控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/profile")
public class DrmProfileController extends BaseController {

	/**
	 * 自动注入用户注册的公司信息业务层实现
	 */
	@Autowired
	private IDrmCompanyService<DrmCompany> drmCompanyService;

	@Autowired
	private IDrmCompanyLibService<DrmCompanyLib> drmCompanyLibService;
	
	@Autowired
	private IPtUserService<PtUser> ptUserService;

    @RequestMapping()
	public String index(HttpServletRequest request,Model model){
    	
		PtUser curUser = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
		DrmCompany curcompany = null;
		if(null!=curUser.getCurCompanyId()){
			curcompany = drmCompanyService.getById(curUser.getCurCompanyId());
		}else{
			curcompany = new DrmCompany();
		}
		List<DrmCompany> list = drmCompanyService.getByUserid(curUser.getId(), 2);// 2：上一家
		DrmCompany precompany = (list==null||list.size()==0)?(new DrmCompany()):list.get(0);
		
		if(null==curUser.getCurCompanyId() || (list==null||list.size()==0)){
	    	model.addAttribute("save_profile_success", -1);// 标志要完善个人信息
		}
		
		// 如果是保存后，跳转到此url；设置保存成功标志
		if(null!=request.getSession().getAttribute("save_profile_success")){
			model.addAttribute("save_profile_success", request.getSession().getAttribute("save_profile_success"));
		}
		model.addAttribute("curuser", curUser);
		model.addAttribute("curcompany", curcompany);
		model.addAttribute("precompany", precompany);
		request.getSession().removeAttribute("save_profile_success");
		
		return "drmprofile/pages/profile";
	}
	
	
	@RequestMapping(value = "save")
	public String save (DrmCompany curcompany,DrmCompanyVo precompany, PtUser u, HttpServletRequest request){
		try{
			PtUser curUser = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
			// 1 user已经存在 update
			// 2 curcompany 可能存在，可能不存在  save / update
			// 3 precompany 可能存在，可能不存在  save / update
			
			
			if(curUser.getCurCompanyId()==null){
				//save current company
				curcompany.setCompanyIndex(1);
				curcompany.setUserId(curUser.getId());
				Integer curcomid = drmCompanyService.save(curcompany);
				// update user
				curUser.setCurCompanyId(curcomid);
				curUser.setCurCompanyName(curcompany.getCompanyShotname());
				curUser.setCurDeptName(curcompany.getDeptName());
				
			}else{
				// 已经存了当前公司;更新当前公司信息
				curcompany.setId(curUser.getCurCompanyId());
				curcompany.setCompanyIndex(1);
				curcompany.setUserId(curUser.getId());
				drmCompanyService.update(curcompany);
			}
			DrmCompany pre = precompany.getEntity2();
			if(pre!=null ){
				if(pre.getId()!=null){
					// 有上一家公司的记录
					pre.setCompanyIndex(2);
					pre.setUserId(curUser.getId());
					drmCompanyService.update(pre);
				}else if(!StringUtils.isEmpty(pre.getCompanyShotname())){
					pre.setCompanyIndex(2);
					pre.setUserId(curUser.getId());
					drmCompanyService.save(pre);// 上一家公司

				}
			}
			
			curUser.setQq(u.getQq());
			curUser.setNickname(u.getNickname());
			curUser.setLastname(u.getLastname());
			curUser.setSex(u.getSex());
			curUser.setRealname(u.getRealname());
			curUser.setEmail(request.getParameter("u_email"));
			curUser.setMoneyCount(u.getMoneyCount());
			curUser.setCurCompanyName(curcompany.getCompanyShotname());
			ptUserService.update(curUser);
			// 把更新后的当前用户信息放入session
			request.getSession().setAttribute(Constants.SESSION_LOGINUSER , curUser);

		}
		catch(Exception ex){
			ex.printStackTrace();
			request.getSession().setAttribute("save_profile_success", 0);
		}
		// 标志保存成功
		request.getSession().setAttribute("save_profile_success", 1);
		return "redirect:/profile";
	}

	/**
	 * 用户填写的公司名称不存在公司原始库中则发邮件通知好职客
	 * @param curname
	 * @param prename
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "sendMailTip/{curname}/{prename}")
	public String sendMailTip(@PathVariable("curname") String curname,@PathVariable("prename") String prename , HttpServletRequest request){

		PtUser curUser = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
		
		if(null!=curname && !"".equals(curname.trim())){
			// 判断填写的[当前]公司是否存在公司原始库中，如果不存在发邮件通知haozhike@yeah.net
			List<DrmCompanyLib> curLibs = drmCompanyLibService.queryByParams(curname.trim());
			if(null==curLibs||curLibs.size()==0){
				// 发邮件
				MailSender mailSender = new MailSender();
				mailSender.sendMail("[好职客]提醒：用户(userid="+curUser.getId()+")保存自己当前公司名称,公司["+ curname.trim() +"]不存在公司原始库中", 
						"<h2>userid:"+curUser.getId()+",当前公司名称:"+ curname.trim() +"</h2>", 
							"haozhike@yeah.net", "用户保存个人信息", null, null, null, null);
			}
		}
		if(null!=prename && !"".equals(prename.trim())){
			// 判断填写的[上一家]公司是否存在公司原始库中，如果不存在发邮件通知haozhike@yeah.net
			List<DrmCompanyLib> preLibs = drmCompanyLibService.queryByParams(prename.trim());
			if(null==preLibs||preLibs.size()==0){
				// 发邮件
				MailSender mailSender = new MailSender();
				mailSender.sendMail("[好职客]提醒：用户(userid="+curUser.getId()+")保存自己上一家公司名称,公司["+ prename.trim() +"]不存在公司原始库中", 
						"<h2>userid:"+curUser.getId()+",上一家公司名称:"+ prename.trim() +"</h2>", 
							"haozhike@yeah.net", "用户保存个人信息", null, null, null, null);
			}
		}
		
		return "1";
	}
}
