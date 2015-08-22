/**
 * Description: TA们都在这里得到了帮助，模拟数据控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:48
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
import com.env.service.intf.IDrmHelpInfoService;

import com.env.dto.DrmHelpInfo;
import com.env.vo.DrmHelpInfoVo;


/**
 * TA们都在这里得到了帮助，模拟数据控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmhelpinfo")
public class DrmHelpInfoController extends BaseController {

	/**
	 * 自动注入TA们都在这里得到了帮助，模拟数据业务层实现
	 */
	@Autowired
	private IDrmHelpInfoService drmHelpInfoService;


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
        
        QueryParams<DrmHelpInfo> queryParams=new QueryParams<DrmHelpInfo>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmHelpInfo> drmHelpInfoList = drmHelpInfoService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmHelpInfoList", drmHelpInfoList);

		return "drmhelpinfo/pages/list";
	}
	
	/**
	 * 去新增TA们都在这里得到了帮助，模拟数据
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmhelpinfo/pages/add";
	}

	/**
	 * 新增TA们都在这里得到了帮助，模拟数据
	 * 
	 * @param drmHelpInfoVo TA们都在这里得到了帮助，模拟数据页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmHelpInfoVo drmHelpInfoVo ){
		Integer id = -1;
		try{
			id = drmHelpInfoService.save(drmHelpInfoVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmhelpinfo/detail/"+id;
	}

	/**
	 * 删除TA们都在这里得到了帮助，模拟数据
	 * 
	 * @param id TA们都在这里得到了帮助，模拟数据页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmHelpInfoService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmhelpinfo/list";
	}

	/**
	 * 去修改TA们都在这里得到了帮助，模拟数据
	 * 
	 * @param id TA们都在这里得到了帮助，模拟数据页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmHelpInfo drmHelpInfoEntity = (DrmHelpInfo) drmHelpInfoService.getById(id);
				model.addAttribute("entity", drmHelpInfoEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmhelpinfo/pages/update";
	}

	/**
	 * 修改TA们都在这里得到了帮助，模拟数据
	 * 
	 * @param drmHelpInfoVo TA们都在这里得到了帮助，模拟数据页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmHelpInfoVo drmHelpInfoVo){
		try{
			drmHelpInfoService.update(drmHelpInfoVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmhelpinfo/detail/"+ drmHelpInfoVo.getEntity().getId();
	}


	/**
	 * 跳转到TA们都在这里得到了帮助，模拟数据详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmHelpInfo com = (DrmHelpInfo) drmHelpInfoService.getById(id);
		model.addAttribute("entity", com);
		return "drmhelpinfo/pages/detail";
	}
}
