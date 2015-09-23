/**
 * Description: 用户提醒平台收录公司控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-09-12 下午 17:50:55
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-09-12   caoyx   1.0         Initial
 */
package com.env.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.commons.utils.StringUtils;
import com.env.constant.Constants;
import com.env.dto.DrmCollNotice;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmCollNoticeService;


/**
 * 用户提醒平台收录公司控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-09-12
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/collnotice")
public class DrmCollNoticeController extends BaseController {

	/**
	 * 自动注入用户提醒平台收录公司业务层实现
	 */
	@Autowired
	private IDrmCollNoticeService drmCollNoticeService;

	/**
	 * 新增用户提醒平台收录公司
	 * 
	 * @param drmCollNoticeVo 用户提醒平台收录公司页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@ResponseBody
	@RequestMapping(value = "save")
	public String save (HttpServletRequest request){
		Integer id = -1;
		try{
			String companyname = request.getParameter("companyname");
			String colltype = request.getParameter("colltype");
			if(!StringUtils.isEmpty(companyname)){
//				companyname = new String(companyname.getBytes("iso-8859-1"),"UTF-8");
				PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
				DrmCollNotice entity = new DrmCollNotice();
				entity.setCompanyShotname(companyname);
				entity.setUserId((user==null)?0:user.getId());
				if(!StringUtils.isEmpty(colltype)){
//					colltype = new String(colltype.getBytes("iso-8859-1"),"UTF-8");
					entity.setCollType(colltype);
				}
				id = drmCollNoticeService.save(entity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "0";
		}
		return "1";
	}

}
