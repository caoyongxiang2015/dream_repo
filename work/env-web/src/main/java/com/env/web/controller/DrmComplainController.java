/**
 * Description: 投诉控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:47
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
import com.env.service.intf.IDrmComplainService;

import com.env.dto.DrmComplain;
import com.env.vo.DrmComplainVo;


/**
 * 投诉控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmcomplain")
public class DrmComplainController extends BaseController {

	/**
	 * 自动注入投诉业务层实现
	 */
	@Autowired
	private IDrmComplainService drmComplainService;


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
        
        QueryParams<DrmComplain> queryParams=new QueryParams<DrmComplain>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmComplain> drmComplainList = drmComplainService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmComplainList", drmComplainList);

		return "drmcomplain/pages/list";
	}
	
	/**
	 * 去新增投诉
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmcomplain/pages/add";
	}

	/**
	 * 新增投诉
	 * 
	 * @param drmComplainVo 投诉页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmComplainVo drmComplainVo ){
		Integer id = -1;
		try{
			id = drmComplainService.save(drmComplainVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmcomplain/detail/"+id;
	}

	/**
	 * 删除投诉
	 * 
	 * @param id 投诉页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmComplainService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmcomplain/list";
	}

	/**
	 * 去修改投诉
	 * 
	 * @param id 投诉页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmComplain drmComplainEntity = (DrmComplain) drmComplainService.getById(id);
				model.addAttribute("entity", drmComplainEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmcomplain/pages/update";
	}

	/**
	 * 修改投诉
	 * 
	 * @param drmComplainVo 投诉页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmComplainVo drmComplainVo){
		try{
			drmComplainService.update(drmComplainVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmcomplain/detail/"+ drmComplainVo.getEntity().getId();
	}


	/**
	 * 跳转到投诉详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmComplain com = (DrmComplain) drmComplainService.getById(id);
		model.addAttribute("entity", com);
		return "drmcomplain/pages/detail";
	}
}
