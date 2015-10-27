/**
 * Description: PtRoleUser控制器
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
import com.env.service.intf.IPtRoleUserService;

import com.env.dto.PtRoleUser;
import com.env.vo.PtRoleUserVo;


/**
 * PtRoleUser控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
//@Controller
//@RequestMapping("/ptroleuser")
public class PtRoleUserController extends BaseController {

	/**
	 * 自动注入PtRoleUser业务层实现
	 */
	@Autowired
	private IPtRoleUserService ptRoleUserService;


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
        
        QueryParams<PtRoleUser> queryParams=new QueryParams<PtRoleUser>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<PtRoleUser> ptRoleUserList = ptRoleUserService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("ptRoleUserList", ptRoleUserList);

		return "ptroleuser/pages/list";
	}
	
	/**
	 * 去新增PtRoleUser
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "ptroleuser/pages/add";
	}

	/**
	 * 新增PtRoleUser
	 * 
	 * @param ptRoleUserVo PtRoleUser页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (PtRoleUserVo ptRoleUserVo ){
		Integer id = -1;
		try{
			id = ptRoleUserService.save(ptRoleUserVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptroleuser/detail/"+id;
	}

	/**
	 * 删除PtRoleUser
	 * 
	 * @param id PtRoleUser页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    ptRoleUserService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptroleuser/list";
	}

	/**
	 * 去修改PtRoleUser
	 * 
	 * @param id PtRoleUser页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				PtRoleUser ptRoleUserEntity = (PtRoleUser) ptRoleUserService.getById(id);
				model.addAttribute("entity", ptRoleUserEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "ptroleuser/pages/update";
	}

	/**
	 * 修改PtRoleUser
	 * 
	 * @param ptRoleUserVo PtRoleUser页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (PtRoleUserVo ptRoleUserVo){
		try{
			ptRoleUserService.update(ptRoleUserVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptroleuser/detail/"+ ptRoleUserVo.getEntity().getId();
	}


	/**
	 * 跳转到PtRoleUser详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		PtRoleUser com = (PtRoleUser) ptRoleUserService.getById(id);
		model.addAttribute("entity", com);
		return "ptroleuser/pages/detail";
	}
}
