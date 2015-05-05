/**
 * Description: DrmDeptLib控制器
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
import com.env.service.intf.IDrmDeptLibService;

import com.env.dto.DrmDeptLib;
import com.env.vo.DrmDeptLibVo;


/**
 * DrmDeptLib控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmdeptlib")
public class DrmDeptLibController extends BaseController {

	/**
	 * 自动注入DrmDeptLib业务层实现
	 */
	@Autowired
	private IDrmDeptLibService drmDeptLibService;


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
        
        QueryParams<DrmDeptLib> queryParams=new QueryParams<DrmDeptLib>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmDeptLib> drmDeptLibList = drmDeptLibService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmDeptLibList", drmDeptLibList);

		return "drmdeptlib/pages/list";
	}
	
	/**
	 * 去新增DrmDeptLib
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmdeptlib/pages/add";
	}

	/**
	 * 新增DrmDeptLib
	 * 
	 * @param drmDeptLibVo DrmDeptLib页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmDeptLibVo drmDeptLibVo ){
		Integer id = -1;
		try{
			id = drmDeptLibService.save(drmDeptLibVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmdeptlib/detail/"+id;
	}

	/**
	 * 删除DrmDeptLib
	 * 
	 * @param id DrmDeptLib页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmDeptLibService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmdeptlib/list";
	}

	/**
	 * 去修改DrmDeptLib
	 * 
	 * @param id DrmDeptLib页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmDeptLib drmDeptLibEntity = (DrmDeptLib) drmDeptLibService.getById(id);
				model.addAttribute("entity", drmDeptLibEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmdeptlib/pages/update";
	}

	/**
	 * 修改DrmDeptLib
	 * 
	 * @param drmDeptLibVo DrmDeptLib页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmDeptLibVo drmDeptLibVo){
		try{
			drmDeptLibService.update(drmDeptLibVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmdeptlib/detail/"+ drmDeptLibVo.getEntity().getId();
	}


	/**
	 * 跳转到DrmDeptLib详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmDeptLib com = (DrmDeptLib) drmDeptLibService.getById(id);
		model.addAttribute("entity", com);
		return "drmdeptlib/pages/detail";
	}
}
