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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.constant.Constants;
import com.env.dto.PtFeedback;
import com.env.dto.PtUser;
import com.env.service.intf.IPtFeedbackService;
import com.env.vo.PtFeedbackVo;


/**
 * 意见反馈控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/ptfeedback")
public class PtFeedbackController extends BaseController {

	/**
	 * 自动注入意见反馈业务层实现
	 */
	@Autowired
	private IPtFeedbackService ptFeedbackService;

	/**
	 * 去新增意见反馈
	 * 
	 * @return 结果视图
	 */
	@RequestMapping()
	public String index(){
		return "drmfeedback/pages/feedback";
	}

	/**
	 * 新增意见反馈
	 * 
	 * @param ptFeedbackVo 意见反馈页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@ResponseBody
	@RequestMapping(value = "save")
	public String save (PtFeedbackVo ptFeedbackVo , HttpServletRequest request){
		Integer id = -1;
		try{
			PtUser user = (PtUser) request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
			PtFeedback entity = ptFeedbackVo.getEntity();
			if(null!=user){
				entity.setUserId(user.getId());
				entity.setUserName(user.getNickname());
			}
			id = ptFeedbackService.save(entity);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "-1";
		}
		return "1";
	}

}
