/**
 * Description: PtPermission控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:50
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
import com.env.service.intf.IPtPermissionService;

import com.env.dto.PtPermission;
import com.env.vo.PtPermissionVo;


/**
 * PtPermission控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
//@Controller
//@RequestMapping("/ptpermission")
public class PtPermissionController extends BaseController {

	/**
	 * 自动注入PtPermission业务层实现
	 */
	@Autowired
	private IPtPermissionService ptPermissionService;


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
        
        QueryParams<PtPermission> queryParams=new QueryParams<PtPermission>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<PtPermission> ptPermissionList = ptPermissionService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("ptPermissionList", ptPermissionList);

		return "ptpermission/pages/list";
	}
	
	/**
	 * 去新增PtPermission
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "ptpermission/pages/add";
	}

	/**
	 * 新增PtPermission
	 * 
	 * @param ptPermissionVo PtPermission页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (PtPermissionVo ptPermissionVo ){
		Integer id = -1;
		try{
			id = ptPermissionService.save(ptPermissionVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptpermission/detail/"+id;
	}

	/**
	 * 删除PtPermission
	 * 
	 * @param id PtPermission页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    ptPermissionService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptpermission/list";
	}

	/**
	 * 去修改PtPermission
	 * 
	 * @param id PtPermission页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				PtPermission ptPermissionEntity = (PtPermission) ptPermissionService.getById(id);
				model.addAttribute("entity", ptPermissionEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "ptpermission/pages/update";
	}

	/**
	 * 修改PtPermission
	 * 
	 * @param ptPermissionVo PtPermission页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (PtPermissionVo ptPermissionVo){
		try{
			ptPermissionService.update(ptPermissionVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptpermission/detail/"+ ptPermissionVo.getEntity().getId();
	}


	/**
	 * 跳转到PtPermission详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		PtPermission com = (PtPermission) ptPermissionService.getById(id);
		model.addAttribute("entity", com);
		return "ptpermission/pages/detail";
	}
}
