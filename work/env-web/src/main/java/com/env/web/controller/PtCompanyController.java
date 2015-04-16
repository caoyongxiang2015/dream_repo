/**
 * Description: PtCompany控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-01-10 上午 11:00:17
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-01-10   caoyx   1.0         Initial
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
import com.env.service.intf.IPtCompanyService;

import com.env.dto.PtCompany;
import com.env.vo.PtCompanyVo;


/**
 * PtCompany控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-10
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/ptcompany")
public class PtCompanyController extends BaseController {

	/**
	 * 自动注入PtCompany业务层实现
	 */
	@Autowired
	private IPtCompanyService ptCompanyService;


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
        
        QueryParams<PtCompany> queryParams=new QueryParams<PtCompany>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<PtCompany> ptCompanyList = ptCompanyService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("ptCompanyList", ptCompanyList);

		return "ptcompany/pages/list";
	}
	
	/**
	 * 去新增PtCompany
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "ptcompany/pages/add";
	}

	/**
	 * 新增PtCompany
	 * 
	 * @param ptCompanyVo PtCompany页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (PtCompanyVo ptCompanyVo ){
		Integer id = -1;
		try{
			id = ptCompanyService.save(ptCompanyVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptcompany/detail/"+id;
	}

	/**
	 * 删除PtCompany
	 * 
	 * @param id PtCompany页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    ptCompanyService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptcompany/list";
	}

	/**
	 * 去修改PtCompany
	 * 
	 * @param id PtCompany页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				PtCompany ptCompanyEntity = (PtCompany) ptCompanyService.getById(id);
				model.addAttribute("entity", ptCompanyEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "ptcompany/pages/update";
	}

	/**
	 * 修改PtCompany
	 * 
	 * @param ptCompanyVo PtCompany页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (PtCompanyVo ptCompanyVo){
		try{
			ptCompanyService.update(ptCompanyVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/ptcompany/detail/"+ ptCompanyVo.getEntity().getId();
	}


	/**
	 * 跳转到PtCompany详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		PtCompany com = (PtCompany) ptCompanyService.getById(id);
		model.addAttribute("entity", com);
		return "ptcompany/pages/detail";
	}
}
