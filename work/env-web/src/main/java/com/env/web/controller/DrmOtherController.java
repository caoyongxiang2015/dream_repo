/**
 * Description: 意见反馈控制器
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.enums.LetterCodedLabeledEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.constant.Constants;
import com.env.dto.DrmLetter;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmLetterService;


/**
 * 关于我们控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping()
public class DrmOtherController extends BaseController {

	@Autowired
	private IDrmLetterService<DrmLetter> drmLetterService;
	
	/**
	 * 去新增意见反馈
	 * 
	 * @return 结果视图
	 */
	@RequestMapping("/about")
	public String about(){
		return "other/pages/about";
	}
	@RequestMapping("/terms")
	public String terms(){
		return "other/pages/terms";
	}
	@RequestMapping("/sysletter")
	public String sysletter(HttpServletRequest request){
		HttpSession session = request.getSession();
        PtUser curUser = (PtUser) session.getAttribute(Constants.SESSION_LOGINUSER);
        if(curUser==null){
        	return "redirect:/";
        }
        request.setAttribute("curUser", curUser);
		return "other/pages/sysletter";
	}
	
	@ResponseBody
	@RequestMapping("/sysletter/send")
	public String sysletterSave(HttpServletRequest request){
		HttpSession session = request.getSession();
        PtUser curUser = (PtUser) session.getAttribute(Constants.SESSION_LOGINUSER);
        DrmLetter entity = new DrmLetter();
        entity.setReceiveUserid(curUser.getId());
        entity.setSendUserid(-1);
		drmLetterService.save(entity);
		
		return "1";
	}
	@ResponseBody
	@RequestMapping("/sysletter/read")
	public String sysletterRead(HttpServletRequest request){
		HttpSession session = request.getSession();
		PtUser curUser = (PtUser) session.getAttribute(Constants.SESSION_LOGINUSER);
		drmLetterService.delete(curUser.getId());
		
		return "1";
	}
	


}
