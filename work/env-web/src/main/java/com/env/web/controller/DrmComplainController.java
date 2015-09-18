/**
 * Description: 投诉控制器
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

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import com.env.dao.api.Page;
import com.env.dao.api.QueryParams;
import com.env.service.intf.IDrmComplainService;
import com.env.dto.DrmComplain;
import com.env.vo.DrmComplainVo;


/**
 * 投诉控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/complain")
public class DrmComplainController extends BaseController {

	/**
	 * 自动注入投诉业务层实现
	 */
	@Autowired
	private IDrmComplainService<DrmComplain> drmComplainService;

	@ResponseBody
	@RequestMapping(value="/comp", method=RequestMethod.POST ,produces = "application/json; charset=utf-8")  
	public String comp (HttpServletRequest request){
		String complainReason = request.getParameter("reason");
		String remark = request.getParameter("remark");
		String reqId = request.getParameter("reqId");
		String receiveId = request.getParameter("receiveId");
		DrmComplain entity = new DrmComplain();
		
		try{
			entity.setReqId( new Integer(reqId));
			entity.setComplainReason(complainReason);
			entity.setRemark(remark);
			entity.setReceiveUserId( new Integer(receiveId));
		}catch(Exception e){
			e.printStackTrace();
			return "0";
		}
		
		drmComplainService.save(entity);
		return "1";
	}
}
