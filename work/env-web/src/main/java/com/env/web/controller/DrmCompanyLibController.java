/**
 * Description: 公司库，搜索使用控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:46
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
import com.env.service.intf.IDrmCompanyLibService;
import com.env.dto.DrmCompanyLib;
import com.env.vo.DrmCompanyLibVo;


/**
 * 公司库，搜索使用控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmsearch")
public class DrmCompanyLibController extends BaseController {

	/**
	 * 自动注入公司库，搜索使用业务层实现
	 */
	@Autowired
	private IDrmCompanyLibService drmCompanyLibService;


    @RequestMapping()
	public String index(){
		return "drmsearch/pages/search";
	}
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
        
        QueryParams<DrmCompanyLib> queryParams=new QueryParams<DrmCompanyLib>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmCompanyLib> drmCompanyLibList = drmCompanyLibService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmCompanyLibList", drmCompanyLibList);

		return "drmcompanylib/pages/list";
	}
	
	/**
	 * 去新增公司库，搜索使用
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmcompanylib/pages/add";
	}

	/**
	 * 新增公司库，搜索使用
	 * 
	 * @param drmCompanyLibVo 公司库，搜索使用页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmCompanyLibVo drmCompanyLibVo ){
		Integer id = -1;
		try{
			id = drmCompanyLibService.save(drmCompanyLibVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmcompanylib/detail/"+id;
	}

	/**
	 * 删除公司库，搜索使用
	 * 
	 * @param id 公司库，搜索使用页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmCompanyLibService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmcompanylib/list";
	}

	/**
	 * 去修改公司库，搜索使用
	 * 
	 * @param id 公司库，搜索使用页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmCompanyLib drmCompanyLibEntity = (DrmCompanyLib) drmCompanyLibService.getById(id);
				model.addAttribute("entity", drmCompanyLibEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmcompanylib/pages/update";
	}

	/**
	 * 修改公司库，搜索使用
	 * 
	 * @param drmCompanyLibVo 公司库，搜索使用页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmCompanyLibVo drmCompanyLibVo){
		try{
			drmCompanyLibService.update(drmCompanyLibVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmcompanylib/detail/"+ drmCompanyLibVo.getEntity().getId();
	}


	/**
	 * 跳转到公司库，搜索使用详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmCompanyLib com = (DrmCompanyLib) drmCompanyLibService.getById(id);
		model.addAttribute("entity", com);
		return "drmcompanylib/pages/detail";
	}
}
