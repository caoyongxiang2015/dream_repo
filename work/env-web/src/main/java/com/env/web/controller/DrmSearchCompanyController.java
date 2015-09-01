/**
 * Description: 用户发布需求；搜索公司 都把公司记录下来控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-09-01 下午 21:01:45
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-09-01   caoyx   1.0         Initial
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
import com.env.service.intf.IDrmSearchCompanyService;

import com.env.dto.DrmSearchCompany;
import com.env.vo.DrmSearchCompanyVo;


/**
 * 用户发布需求；搜索公司 都把公司记录下来控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-09-01
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmsearchcompany")
public class DrmSearchCompanyController extends BaseController {

	/**
	 * 自动注入用户发布需求；搜索公司 都把公司记录下来业务层实现
	 */
	@Autowired
	private IDrmSearchCompanyService drmSearchCompanyService;


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
        
        QueryParams<DrmSearchCompany> queryParams=new QueryParams<DrmSearchCompany>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmSearchCompany> drmSearchCompanyList = drmSearchCompanyService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmSearchCompanyList", drmSearchCompanyList);

		return "drmsearchcompany/pages/list";
	}
	
	/**
	 * 去新增用户发布需求；搜索公司 都把公司记录下来
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmsearchcompany/pages/add";
	}

	/**
	 * 新增用户发布需求；搜索公司 都把公司记录下来
	 * 
	 * @param drmSearchCompanyVo 用户发布需求；搜索公司 都把公司记录下来页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmSearchCompanyVo drmSearchCompanyVo ){
		Integer id = -1;
		try{
			id = drmSearchCompanyService.save(drmSearchCompanyVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmsearchcompany/detail/"+id;
	}

	/**
	 * 删除用户发布需求；搜索公司 都把公司记录下来
	 * 
	 * @param id 用户发布需求；搜索公司 都把公司记录下来页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmSearchCompanyService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmsearchcompany/list";
	}

	/**
	 * 去修改用户发布需求；搜索公司 都把公司记录下来
	 * 
	 * @param id 用户发布需求；搜索公司 都把公司记录下来页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmSearchCompany drmSearchCompanyEntity = (DrmSearchCompany) drmSearchCompanyService.getById(id);
				model.addAttribute("entity", drmSearchCompanyEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmsearchcompany/pages/update";
	}

	/**
	 * 修改用户发布需求；搜索公司 都把公司记录下来
	 * 
	 * @param drmSearchCompanyVo 用户发布需求；搜索公司 都把公司记录下来页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmSearchCompanyVo drmSearchCompanyVo){
		try{
			drmSearchCompanyService.update(drmSearchCompanyVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmsearchcompany/detail/"+ drmSearchCompanyVo.getEntity().getId();
	}


	/**
	 * 跳转到用户发布需求；搜索公司 都把公司记录下来详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmSearchCompany com = (DrmSearchCompany) drmSearchCompanyService.getById(id);
		model.addAttribute("entity", com);
		return "drmsearchcompany/pages/detail";
	}
}
