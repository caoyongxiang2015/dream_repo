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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.constant.Constants;
import com.env.dao.api.Page;
import com.env.dao.api.QueryParams;
import com.env.dto.DrmLetter;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmLetterService;
import com.env.util.SmsSender;
import com.env.vo.DrmLetterVo;


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

    @Autowired
    SmsSender smsSender;
	/**
	 * 自动注入DrmLetter业务层实现
	 */
	@Autowired
	private IDrmLetterService drmLetterService;


	@RequestMapping()
	public String index(HttpServletRequest request){
		
		PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
		
		List<DrmLetter> ls = drmLetterService.queryLetter(user.getId());
		request.setAttribute("ls", ls);
		return "drmletter/pages/letter_list";
	}
	
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
	public String sendletter (DrmLetterVo drmLetterVo ){
		Integer id = -1;
		try{
			id = drmLetterService.save(drmLetterVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/";
	}

	
	// TODO test
	@ResponseBody
	@RequestMapping(value="/send")
	public String send(){

        if (smsSender.sendSms("13390793901", "短信内容123abc")) {
        	return "发送成功";
        }
		return "发送失败fail";
	}
	
	/**
	 * 去列表页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list")
	public String list(Integer number , HttpServletRequest request){

        // 拿到所有的入参放到map里
        Map<String, Object> searchParams = new HashMap<String, Object>();//Servlets.getParametersStartingWith(request, null);
        
        Page page = new Page();
        
        if (null != number) {
            page.setCurrentPage(number);
            String pageSize = request.getParameter("pageSize");
            if(null != pageSize && !"".equals(pageSize)){
                page.setPageSize(Integer.parseInt(pageSize));
            }
        }
        
        QueryParams<DrmLetter> queryParams=new QueryParams<DrmLetter>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmLetter> drmLetterList = drmLetterService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmLetterList", drmLetterList);

		return "drmletter/pages/list";
	}
	

	/**
	 * 新增DrmLetter
	 * 
	 * @param drmLetterVo DrmLetter页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmLetterVo drmLetterVo ){
		Integer id = -1;
		try{
			id = drmLetterService.save(drmLetterVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmletter/detail/"+id;
	}

	
}
