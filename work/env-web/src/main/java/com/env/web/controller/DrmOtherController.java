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
@RequestMapping()
public class DrmOtherController extends BaseController {

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


}
