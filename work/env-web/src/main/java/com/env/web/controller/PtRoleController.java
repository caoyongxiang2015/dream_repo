/**
 * Description: PtRole控制器
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
import com.env.service.intf.IPtRoleService;

import com.env.dto.PtRole;
import com.env.vo.PtRoleVo;


/**
 * PtRole控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
//@Controller
//@RequestMapping("/ptrole")
public class PtRoleController extends BaseController {

	/**
	 * 自动注入PtRole业务层实现
	 */
	@Autowired
	private IPtRoleService ptRoleService;


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
        
        QueryParams<PtRole> queryParams=new QueryParams<PtRole>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<PtRole> ptRoleList = ptRoleService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("ptRoleList", ptRoleList);

		return "ptrole/pages/list";
	}
	
	/**
	 * 去新增PtRole
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "ptrole/pages/add";
	}

	/**
	 * 新增PtRole
	 * 
	 * @param ptRoleVo PtRole页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (PtRoleVo ptRoleVo ){
		Integer id = -1;
		try{
			id = ptRoleService.save(ptRoleVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptrole/detail/"+id;
	}

	/**
	 * 删除PtRole
	 * 
	 * @param id PtRole页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    ptRoleService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptrole/list";
	}

	/**
	 * 去修改PtRole
	 * 
	 * @param id PtRole页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				PtRole ptRoleEntity = (PtRole) ptRoleService.getById(id);
				model.addAttribute("entity", ptRoleEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "ptrole/pages/update";
	}

	/**
	 * 修改PtRole
	 * 
	 * @param ptRoleVo PtRole页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (PtRoleVo ptRoleVo){
		try{
			ptRoleService.update(ptRoleVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptrole/detail/"+ ptRoleVo.getEntity().getId();
	}


	/**
	 * 跳转到PtRole详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		PtRole com = (PtRole) ptRoleService.getById(id);
		model.addAttribute("entity", com);
		return "ptrole/pages/detail";
	}
}
