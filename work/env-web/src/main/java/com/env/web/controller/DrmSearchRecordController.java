/**
 * Description: 记录用户对公司的搜索次数控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:49
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
import com.env.service.intf.IDrmSearchRecordService;

import com.env.dto.DrmSearchRecord;
import com.env.vo.DrmSearchRecordVo;


/**
 * 记录用户对公司的搜索次数控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmsearchrecord")
public class DrmSearchRecordController extends BaseController {

	/**
	 * 自动注入记录用户对公司的搜索次数业务层实现
	 */
	@Autowired
	private IDrmSearchRecordService drmSearchRecordService;


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
        
        QueryParams<DrmSearchRecord> queryParams=new QueryParams<DrmSearchRecord>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmSearchRecord> drmSearchRecordList = drmSearchRecordService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmSearchRecordList", drmSearchRecordList);

		return "drmsearchrecord/pages/list";
	}
	
	/**
	 * 去新增记录用户对公司的搜索次数
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmsearchrecord/pages/add";
	}

	/**
	 * 新增记录用户对公司的搜索次数
	 * 
	 * @param drmSearchRecordVo 记录用户对公司的搜索次数页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmSearchRecordVo drmSearchRecordVo ){
		Integer id = -1;
		try{
			id = drmSearchRecordService.save(drmSearchRecordVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmsearchrecord/detail/"+id;
	}

	/**
	 * 删除记录用户对公司的搜索次数
	 * 
	 * @param id 记录用户对公司的搜索次数页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmSearchRecordService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmsearchrecord/list";
	}

	/**
	 * 去修改记录用户对公司的搜索次数
	 * 
	 * @param id 记录用户对公司的搜索次数页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmSearchRecord drmSearchRecordEntity = (DrmSearchRecord) drmSearchRecordService.getById(id);
				model.addAttribute("entity", drmSearchRecordEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmsearchrecord/pages/update";
	}

	/**
	 * 修改记录用户对公司的搜索次数
	 * 
	 * @param drmSearchRecordVo 记录用户对公司的搜索次数页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmSearchRecordVo drmSearchRecordVo){
		try{
			drmSearchRecordService.update(drmSearchRecordVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmsearchrecord/detail/"+ drmSearchRecordVo.getEntity().getId();
	}


	/**
	 * 跳转到记录用户对公司的搜索次数详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmSearchRecord com = (DrmSearchRecord) drmSearchRecordService.getById(id);
		model.addAttribute("entity", com);
		return "drmsearchrecord/pages/detail";
	}
}
