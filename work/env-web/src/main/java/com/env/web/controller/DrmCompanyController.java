/**
 * Description: DrmCompany控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:37:51
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.env.commons.utils.UserUtils;
import com.env.dao.api.Page;
import com.env.dao.api.QueryParams;
import com.env.dto.DrmCompany;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmCompanyService;
import com.env.vo.DrmCompanyVo;
import com.env.vo.DrmDeptVo;


/**
 * DrmCompany控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmcompany")
public class DrmCompanyController extends BaseController {

	/**
	 * 自动注入DrmCompany业务层实现
	 */
	@Autowired
	private IDrmCompanyService drmCompanyService;


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
        
        QueryParams<DrmCompany> queryParams=new QueryParams<DrmCompany>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmCompany> drmCompanyList = drmCompanyService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmCompanyList", drmCompanyList);

		return "drmcompany/pages/list";
	}
	
	/**
	 * 去新增DrmCompany
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmcompany/pages/add";
	}

	/**
	 * 新增DrmCompany
	 * 
	 * @param drmCompanyVo DrmCompany页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmCompanyVo drmCompanyVo,DrmDeptVo drmDeptVo ){
		try{
			PtUser user = (PtUser)UserUtils.getCurrentUser();
//			drmCompanyService.saveCompanyAndDept(drmCompanyVo.getEntity(), drmDeptVo.getEntity());
			drmCompanyService.saveCompanyAndDept(drmCompanyVo.getEntity(), drmDeptVo.getEntity(), user.getId());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/myhome";
	}

	/**
	 * 删除DrmCompany
	 * 
	 * @param id DrmCompany页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@ResponseBody
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
//			    drmCompanyService.delete(id);
			    drmCompanyService.deleteCompanyAndDept(id);
			}else{
				return "0";
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "-1";
		}
		return "1";
	}

	/**
	 * 去修改DrmCompany
	 * 
	 * @param id DrmCompany页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmCompany drmCompanyEntity = (DrmCompany) drmCompanyService.getById(id);
				model.addAttribute("entity", drmCompanyEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmcompany/pages/update";
	}

	/**
	 * 修改DrmCompany
	 * 
	 * @param drmCompanyVo DrmCompany页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmCompanyVo drmCompanyVo){
		try{
			drmCompanyService.update(drmCompanyVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmcompany/detail/"+ drmCompanyVo.getEntity().getId();
	}


	/**
	 * 跳转到DrmCompany详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmCompany com = (DrmCompany) drmCompanyService.getById(id);
		model.addAttribute("entity", com);
		return "drmcompany/pages/detail";
	}
}
