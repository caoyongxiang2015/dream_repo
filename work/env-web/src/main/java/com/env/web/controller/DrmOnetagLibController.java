/**
 * Description: DrmOnetagLib控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:37:53
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
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
import com.env.service.intf.IDrmOnetagLibService;

import com.env.dto.DrmOnetagLib;
import com.env.vo.DrmOnetagLibVo;


/**
 * DrmOnetagLib控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmonetaglib")
public class DrmOnetagLibController extends BaseController {

	/**
	 * 自动注入DrmOnetagLib业务层实现
	 */
	@Autowired
	private IDrmOnetagLibService drmOnetagLibService;


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
        
        QueryParams<DrmOnetagLib> queryParams=new QueryParams<DrmOnetagLib>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmOnetagLib> drmOnetagLibList = drmOnetagLibService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmOnetagLibList", drmOnetagLibList);

		return "drmonetaglib/pages/list";
	}
	
	/**
	 * 去新增DrmOnetagLib
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmonetaglib/pages/add";
	}

	/**
	 * 新增DrmOnetagLib
	 * 
	 * @param drmOnetagLibVo DrmOnetagLib页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmOnetagLibVo drmOnetagLibVo ){
		Integer id = -1;
		try{
			id = drmOnetagLibService.save(drmOnetagLibVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmonetaglib/detail/"+id;
	}

	/**
	 * 删除DrmOnetagLib
	 * 
	 * @param id DrmOnetagLib页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmOnetagLibService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmonetaglib/list";
	}

	/**
	 * 去修改DrmOnetagLib
	 * 
	 * @param id DrmOnetagLib页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmOnetagLib drmOnetagLibEntity = (DrmOnetagLib) drmOnetagLibService.getById(id);
				model.addAttribute("entity", drmOnetagLibEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmonetaglib/pages/update";
	}

	/**
	 * 修改DrmOnetagLib
	 * 
	 * @param drmOnetagLibVo DrmOnetagLib页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmOnetagLibVo drmOnetagLibVo){
		try{
			drmOnetagLibService.update(drmOnetagLibVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmonetaglib/detail/"+ drmOnetagLibVo.getEntity().getId();
	}


	/**
	 * 跳转到DrmOnetagLib详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmOnetagLib com = (DrmOnetagLib) drmOnetagLibService.getById(id);
		model.addAttribute("entity", com);
		return "drmonetaglib/pages/detail";
	}
}
