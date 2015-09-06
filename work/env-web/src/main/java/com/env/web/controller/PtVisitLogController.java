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
import com.env.service.intf.IPtVisitLogService;

import com.env.dto.PtVisitLog;
import com.env.vo.PtVisitLogVo;


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
        
        QueryParams<PtVisitLog> queryParams=new QueryParams<PtVisitLog>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<PtVisitLog> ptVisitLogList = ptVisitLogService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("ptVisitLogList", ptVisitLogList);

		return "ptvisitlog/pages/list";
	}
	
	/**
	 * 去新增url访问日志
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "ptvisitlog/pages/add";
	}

	/**
	 * 新增url访问日志
	 * 
	 * @param ptVisitLogVo url访问日志页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (PtVisitLogVo ptVisitLogVo ){
		Integer id = -1;
		try{
			id = ptVisitLogService.save(ptVisitLogVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptvisitlog/detail/"+id;
	}

	/**
	 * 删除url访问日志
	 * 
	 * @param id url访问日志页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    ptVisitLogService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptvisitlog/list";
	}

	/**
	 * 去修改url访问日志
	 * 
	 * @param id url访问日志页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				PtVisitLog ptVisitLogEntity = (PtVisitLog) ptVisitLogService.getById(id);
				model.addAttribute("entity", ptVisitLogEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "ptvisitlog/pages/update";
	}

	/**
	 * 修改url访问日志
	 * 
	 * @param ptVisitLogVo url访问日志页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (PtVisitLogVo ptVisitLogVo){
		try{
			ptVisitLogService.update(ptVisitLogVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptvisitlog/detail/"+ ptVisitLogVo.getEntity().getId();
	}


	/**
	 * 跳转到url访问日志详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		PtVisitLog com = (PtVisitLog) ptVisitLogService.getById(id);
		model.addAttribute("entity", com);
		return "ptvisitlog/pages/detail";
	}
}
