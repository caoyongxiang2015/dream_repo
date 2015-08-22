/**
 * Description: PtUser控制器
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
import com.env.service.intf.IPtUserService;

import com.env.dto.PtUser;
import com.env.vo.PtUserVo;


/**
 * PtUser控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/ptuser")
public class PtUserController extends BaseController {

	/**
	 * 自动注入PtUser业务层实现
	 */
	@Autowired
	private IPtUserService ptUserService;


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
        
        QueryParams<PtUser> queryParams=new QueryParams<PtUser>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<PtUser> ptUserList = ptUserService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("ptUserList", ptUserList);

		return "ptuser/pages/list";
	}
	
	/**
	 * 去新增PtUser
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "ptuser/pages/add";
	}

	/**
	 * 新增PtUser
	 * 
	 * @param ptUserVo PtUser页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (PtUserVo ptUserVo ){
		Integer id = -1;
		try{
			id = ptUserService.save(ptUserVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptuser/detail/"+id;
	}

	/**
	 * 删除PtUser
	 * 
	 * @param id PtUser页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    ptUserService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptuser/list";
	}

	/**
	 * 去修改PtUser
	 * 
	 * @param id PtUser页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				PtUser ptUserEntity = (PtUser) ptUserService.getById(id);
				model.addAttribute("entity", ptUserEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "ptuser/pages/update";
	}

	/**
	 * 修改PtUser
	 * 
	 * @param ptUserVo PtUser页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (PtUserVo ptUserVo){
		try{
			ptUserService.update(ptUserVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptuser/detail/"+ ptUserVo.getEntity().getId();
	}


	/**
	 * 跳转到PtUser详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		PtUser com = (PtUser) ptUserService.getById(id);
		model.addAttribute("entity", com);
		return "ptuser/pages/detail";
	}
}
