/**
 * Description: DrmLetter控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:48
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-22   caoyx   1.0         Initial
 */
package com.env.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.constant.Constants;
import com.env.dto.DrmLetter;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmLetterService;
import com.env.service.intf.IPtUserService;
import com.env.util.D1SmsSender;
//import com.env.util.Sender;
import com.env.util.SmsSender;


/**
 * DrmLetter控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmletter")
public class DrmLetterController extends BaseController {

//    @Autowired
//    private SmsSender smsSender;
//	private D1SmsSender smsSender;
    
	/**
	 * 自动注入DrmLetter业务层实现
	 */
	@Autowired
	private IDrmLetterService<DrmLetter> drmLetterService;

	@Autowired
	private IPtUserService<PtUser> ptUserService;

	@RequestMapping()
	public String index(HttpServletRequest request){
		
		PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
		
		List<DrmLetter> ls = drmLetterService.queryLetter(user.getId());
		
		request.setAttribute("ls", ls);
		request.setAttribute("send_success", request.getSession().getAttribute("send_success"));
		request.getSession().removeAttribute("send_success");
		
		return "drmletter/pages/letter_list";
	}
	
	/**
	 * 加载短信内容
	 * @param yourUserId
	 * @param request
	 * @return
	 */
	@RequestMapping("/letterSection/{yourUserid}")
	public String letterSection(@PathVariable("yourUserid")  Integer yourUserId, HttpServletRequest request){
		
		PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
		
		List<DrmLetter> ds = drmLetterService.letterDetail(user.getId(),yourUserId);
		
		request.setAttribute("ds", ds);
		request.setAttribute("myUserid", user.getId());
		request.setAttribute("yourUserId", yourUserId);
		
		return "drmletter/pages/letterSection";
	}

	@RequestMapping(value = "sendletter")
	public String sendletter ( HttpServletRequest request){
		Integer id = -1;
		try{
			PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
			
			DrmLetter entity = new DrmLetter();
			String receiveUserid = request.getParameter("receiveUserid");
			String content = request.getParameter("sendMessage"+receiveUserid);
//			String content = new String(request.getParameter("sendMessage"+receiveUserid).getBytes("iso8859-1"),"gbk");
			
			entity.setContent(content);
			entity.setSendUserid(user.getId());
			entity.setSendUsername(user.getNickname());
			entity.setReceiveUserid(Integer.valueOf(receiveUserid));
			
			PtUser receiveUser = ptUserService.getById(Integer.valueOf(receiveUserid));
			entity.setReceiveUsername(receiveUser.getNickname());
			
			id = drmLetterService.save(entity);
			request.getSession().setAttribute("send_success", 1);
		}
		catch(Exception ex){
			ex.printStackTrace();
			request.getSession().setAttribute("send_success", -1);
		}
		return "redirect:/drmletter";
	}

	/*
	// TODO test
	@ResponseBody
	@RequestMapping(value="/send")
	public String send(){
		Calendar cal = Calendar.getInstance();
		Date d = new Date();
		
        if (smsSender.sendSms("13390793901", "sendSms你好")) {
        	return "发送成功";
        }
		return "发送失败fail";
	}
*/

	
}
