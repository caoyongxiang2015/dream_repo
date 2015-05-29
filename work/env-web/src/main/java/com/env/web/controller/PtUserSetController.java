/**
 * Description: PtUser控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:37:55
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.commons.utils.UserUtils;
import com.env.constant.Constants;
import com.env.dto.PtUser;
import com.env.service.intf.IPtUserService;
import com.env.vo.PtUserVo;


/**
 * PtUser控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/ptuserset")
public class PtUserSetController extends BaseController {

    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PtUserSetController.class);
	/**
	 * 自动注入PtUser业务层实现
	 */
	@Autowired
	private IPtUserService ptUserService;

	// 页面跳转  begin
	
	@RequestMapping("")
	public String toSet(Model model ){
		model.addAttribute("entity", getCurrentUser());
		return "userset/pages/self";
	}
	
	//////////////////////
	@RequestMapping("self")
	public String self(Model model ){
		model.addAttribute("entity", getCurrentUser());
		return "userset/pages/self";
	}
	@RequestMapping("self_edit")
	public String self_edit(Model model ){
		model.addAttribute("entity", getCurrentUser());
		return "userset/pages/self_edit";
	}
	@RequestMapping("self_success")
	public String self_success(Model model ){
		model.addAttribute("entity", getCurrentUser());
		addSuccessMessage(model, "个人信息保存成功");
		return "userset/pages/self";
	}
	
	////////////////
	@RequestMapping("service")
	public String service(Model model ){
		model.addAttribute("entity", getCurrentUser());
		return "userset/pages/service";
	}
	@RequestMapping("service_edit")
	public String service_edit(Model model ){
		model.addAttribute("entity", getCurrentUser());
		return "userset/pages/service_edit";
	}
	@RequestMapping("service_success")
	public String service_success(Model model ){
		model.addAttribute("entity", getCurrentUser());
		addSuccessMessage(model, "服务设置成功");
		return "userset/pages/service";
	}
	
	////////
	@RequestMapping("contact")
	public String contact(Model model){
		model.addAttribute("entity", getCurrentUser());
		return "userset/pages/contact";
	}
	@RequestMapping("contact_edit")
	public String contact_edit(Model model){
		model.addAttribute("entity", getCurrentUser());
		return "userset/pages/contact_edit";
	}
	@RequestMapping("contact_success")
	public String contact_success(Model model){
		model.addAttribute("entity", getCurrentUser());
		addSuccessMessage(model, "联系方式保存成功");
		return "userset/pages/contact";
	}
	
	
	
	@RequestMapping("pwd_edit")
	public String pwd_edit(Model model ){
		model.addAttribute("entity", getCurrentUser());
		return "userset/pages/pwd_edit";
	}
	@RequestMapping("pwd_success")
	public String pwd_success(Model model ){
		model.addAttribute("entity", getCurrentUser());
		addSuccessMessage(model, "密码修改成功");
		return "userset/pages/self";
	}
	

	// 页面跳转 end
	
	
	
	
	
	
	
	
	
	/**
	 * 个人资料-保存
	 * @return
	 */
	@RequestMapping("selfsave")
	public String selfsave(PtUserVo vo,Model model ,HttpServletRequest r){
		try{
			LOGGER.debug(vo.getEntity().toString());
			if(vo.getEntity().getId()!=null){
				PtUser old = (PtUser) ptUserService.getById(vo.getEntity().getId());
				old.setNickname(vo.getEntity().getNickname());
				old.setRealname(vo.getEntity().getRealname());
				old.setSex(vo.getEntity().getSex());
				old.setWorkyears(vo.getEntity().getWorkyears());
				ptUserService.update(old);
			}else{
				ptUserService.save(vo.getEntity());
			}
			setSesstion(r);
		}catch(Exception ex){
			ex.printStackTrace();
			addErrorMessage(model, "操作失败");
			model.addAttribute("entity", getCurrentUser());
			return "userset/pages/self_edit";
		}
		return "redirect:/ptuserset/self_success";
	}

	
	
	/**
	 * 服务设置-保存
	 * @param vo
	 * @param model
	 * @return
	 */
	@RequestMapping("servicesave")
	public String servicesave(PtUserVo vo,Model model ,HttpServletRequest r){
		try{
			LOGGER.debug(vo.getEntity().toString());
			if(vo.getEntity().getId()!=null){
				PtUser old = (PtUser) ptUserService.getById(vo.getEntity().getId());
				old.setIsoffline(vo.getEntity().getIsoffline());
				old.setOfflineprice(vo.getEntity().getOfflineprice());
				ptUserService.update(old);
			}else{
				ptUserService.save(vo.getEntity());
			}
			setSesstion(r);
		}catch(Exception ex){
			ex.printStackTrace();
			addErrorMessage(model, "操作失败");
			model.addAttribute("entity", getCurrentUser());
			return "userset/pages/service_edit";
		}
		return "redirect:/ptuserset/service_success";
	}
	

	/**
	 * 联系方式
	 * @param vo
	 * @param model
	 * @return
	 */
	@RequestMapping("contactsave")
	public String contactsave(PtUserVo vo,Model model ,HttpServletRequest r){
		try{
			LOGGER.debug(vo.getEntity().toString());
			if(vo.getEntity().getId()!=null){
				PtUser old = (PtUser) ptUserService.getById(vo.getEntity().getId());
				old.setPhone(vo.getEntity().getPhone());
				old.setQq(vo.getEntity().getQq());
				old.setEmail(vo.getEntity().getEmail());
				old.setWeixin(vo.getEntity().getWeixin());
				ptUserService.update(old);
			}else{
				ptUserService.save(vo.getEntity());
			}
			setSesstion(r);
		}catch(Exception ex){
			ex.printStackTrace();
			addErrorMessage(model, "操作失败");
			model.addAttribute("entity", getCurrentUser());
			return "userset/pages/contact_edit";
		}
		return "redirect:/ptuserset/contact_success";
	}
	
	

	/**
	 * 密码修改
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("pwdsave")
	public String pwdsave(PtUserVo vo,Model model ,HttpServletRequest r){
		try{
			
			if(null!=vo && null!=vo.getPwdconfirm() && vo.getEntity().getPwd().equals(vo.getPwdconfirm())){
				PtUser old = (PtUser) ptUserService.getById(vo.getEntity().getId());
				old.setPwd(vo.getPwdconfirm());
				ptUserService.update(old);
				setSesstion(r);
			}else{
				addErrorMessage(model, "两次密码不一致");
				model.addAttribute("entity", getCurrentUser());
				return "userset/pages/pwd_edit";
			}
		}catch(Exception ex){
			ex.printStackTrace();
			model.addAttribute("entity", getCurrentUser());
			addErrorMessage(model, "操作失败");
			return "userset/pages/pwd_edit";
		}
		return "redirect:/ptuserset/pwd_success";
	}
	

	/**
	 * 获取当前登录用户
	 * @return
	 */
	private PtUser getCurrentUser(){
		// 获取登录用户信息
		PtUser currentUser = (PtUser) UserUtils.getCurrentUser();
		
		return currentUser;
	}
	
	private void setSesstion(HttpServletRequest r){
		// 获取登录用户信息
		PtUser currentUser = (PtUser) UserUtils.getCurrentUser();
		// 登录用户信息可能修改了，因此重新获取
		PtUser entity = (PtUser) ptUserService.getById(currentUser.getId());
		// 用户信息改变，重新设置session值
		r.getSession().setAttribute(Constants.SESSION_LOGINUSER, entity);
	}
}
