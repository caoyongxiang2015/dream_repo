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

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import com.env.dao.api.Page;
import com.env.dao.api.QueryParams;
import com.env.service.intf.IPtFeedbackService;

import com.env.dto.PtFeedback;
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
        
        QueryParams<PtFeedback> queryParams=new QueryParams<PtFeedback>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<PtFeedback> ptFeedbackList = ptFeedbackService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("ptFeedbackList", ptFeedbackList);

		return "ptfeedback/pages/list";
	}
	
	/**
	 * 去新增意见反馈
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "ptfeedback/pages/add";
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
	@RequestMapping(value = "save")
	public String save (PtFeedbackVo ptFeedbackVo ){
		Integer id = -1;
		try{
			id = ptFeedbackService.save(ptFeedbackVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptfeedback/detail/"+id;
	}

	/**
	 * 删除意见反馈
	 * 
	 * @param id 意见反馈页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    ptFeedbackService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptfeedback/list";
	}

	/**
	 * 去修改意见反馈
	 * 
	 * @param id 意见反馈页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				PtFeedback ptFeedbackEntity = (PtFeedback) ptFeedbackService.getById(id);
				model.addAttribute("entity", ptFeedbackEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "ptfeedback/pages/update";
	}

	/**
	 * 修改意见反馈
	 * 
	 * @param ptFeedbackVo 意见反馈页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (PtFeedbackVo ptFeedbackVo){
		try{
			ptFeedbackService.update(ptFeedbackVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptfeedback/detail/"+ ptFeedbackVo.getEntity().getId();
	}


	/**
	 * 跳转到意见反馈详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		PtFeedback com = (PtFeedback) ptFeedbackService.getById(id);
		model.addAttribute("entity", com);
		return "ptfeedback/pages/detail";
	}
}
