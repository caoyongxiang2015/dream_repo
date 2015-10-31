/**
 * Description: url访问日志控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:51
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-22   caoyx   1.0         Initial
 */
package com.env.web.controller;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.constant.Constants;
import com.env.dto.PtUser;
import com.env.dto.PtVisitLog;
import com.env.service.intf.IPtVisitLogService;


/**
 * url访问日志控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/ptvisitlog")
public class PtVisitLogController extends BaseController {

	/**
	 * 自动注入url访问日志业务层实现
	 */
	@Autowired
	private IPtVisitLogService ptVisitLogService;

	@ResponseBody
	@RequestMapping(value = "save")
	public String save (HttpServletRequest request){
		Integer id = -1;
		try{
			PtVisitLog log = new PtVisitLog();
			

	    	PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
	    	log.setVisitUrl(request.getParameter("access_url"));
	    	String ip = InetAddress.getLocalHost().getHostAddress();
	    	log.setVisitIp(ip);
	    	
	    	if(null!=user){
		    	log.setVisitUserid(user.getId());
		    	log.setVisitUsername(user.getNickname());
		    	log.setRemark(user.getPhone());
	    	}
	    	
			id = ptVisitLogService.save(log);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return ""+id;
	}

}
