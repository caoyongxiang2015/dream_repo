/**
 * Description: DrmDept控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:37:52
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
import com.env.service.intf.IDrmDeptService;

import com.env.dto.DrmDept;
import com.env.vo.DrmDeptVo;


/**
 * DrmDept控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmdept")
public class DrmDeptController extends BaseController {

	/**
	 * 自动注入DrmDept业务层实现
	 */
	@Autowired
	private IDrmDeptService drmDeptService;


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
        
        QueryParams<DrmDept> queryParams=new QueryParams<DrmDept>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmDept> drmDeptList = drmDeptService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmDeptList", drmDeptList);

		return "drmdept/pages/list";
	}
	
	/**
	 * 去新增DrmDept
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmdept/pages/add";
	}

	/**
	 * 新增DrmDept
	 * 
	 * @param drmDeptVo DrmDept页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmDeptVo drmDeptVo ){
		Integer id = -1;
		try{
			id = drmDeptService.save(drmDeptVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmdept/detail/"+id;
	}

	/**
	 * 删除DrmDept
	 * 
	 * @param id DrmDept页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmDeptService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmdept/list";
	}

	/**
	 * 去修改DrmDept
	 * 
	 * @param id DrmDept页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmDept drmDeptEntity = (DrmDept) drmDeptService.getById(id);
				model.addAttribute("entity", drmDeptEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmdept/pages/update";
	}

	/**
	 * 修改DrmDept
	 * 
	 * @param drmDeptVo DrmDept页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmDeptVo drmDeptVo){
		try{
			drmDeptService.update(drmDeptVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmdept/detail/"+ drmDeptVo.getEntity().getId();
	}


	/**
	 * 跳转到DrmDept详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmDept com = (DrmDept) drmDeptService.getById(id);
		model.addAttribute("entity", com);
		return "drmdept/pages/detail";
	}
}
