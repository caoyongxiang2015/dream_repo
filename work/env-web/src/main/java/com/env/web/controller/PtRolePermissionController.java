/**
 * Description: PtRolePermission控制器
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
import com.env.service.intf.IPtRolePermissionService;

import com.env.dto.PtRolePermission;
import com.env.vo.PtRolePermissionVo;


/**
 * PtRolePermission控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
//@Controller
//@RequestMapping("/ptrolepermission")
public class PtRolePermissionController extends BaseController {

	/**
	 * 自动注入PtRolePermission业务层实现
	 */
	@Autowired
	private IPtRolePermissionService ptRolePermissionService;


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
        
        QueryParams<PtRolePermission> queryParams=new QueryParams<PtRolePermission>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<PtRolePermission> ptRolePermissionList = ptRolePermissionService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("ptRolePermissionList", ptRolePermissionList);

		return "ptrolepermission/pages/list";
	}
	
	/**
	 * 去新增PtRolePermission
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "ptrolepermission/pages/add";
	}

	/**
	 * 新增PtRolePermission
	 * 
	 * @param ptRolePermissionVo PtRolePermission页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (PtRolePermissionVo ptRolePermissionVo ){
		Integer id = -1;
		try{
			id = ptRolePermissionService.save(ptRolePermissionVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptrolepermission/detail/"+id;
	}

	/**
	 * 删除PtRolePermission
	 * 
	 * @param id PtRolePermission页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    ptRolePermissionService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptrolepermission/list";
	}

	/**
	 * 去修改PtRolePermission
	 * 
	 * @param id PtRolePermission页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				PtRolePermission ptRolePermissionEntity = (PtRolePermission) ptRolePermissionService.getById(id);
				model.addAttribute("entity", ptRolePermissionEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "ptrolepermission/pages/update";
	}

	/**
	 * 修改PtRolePermission
	 * 
	 * @param ptRolePermissionVo PtRolePermission页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (PtRolePermissionVo ptRolePermissionVo){
		try{
			ptRolePermissionService.update(ptRolePermissionVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptrolepermission/detail/"+ ptRolePermissionVo.getEntity().getId();
	}


	/**
	 * 跳转到PtRolePermission详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		PtRolePermission com = (PtRolePermission) ptRolePermissionService.getById(id);
		model.addAttribute("entity", com);
		return "ptrolepermission/pages/detail";
	}
}
