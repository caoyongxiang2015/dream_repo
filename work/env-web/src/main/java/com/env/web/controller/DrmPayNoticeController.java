/**
 * Description: 付款通知控制器
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
import com.env.service.intf.IDrmPayNoticeService;

import com.env.dto.DrmPayNotice;
import com.env.vo.DrmPayNoticeVo;


/**
 * 付款通知控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmpaynotice")
public class DrmPayNoticeController extends BaseController {

	/**
	 * 自动注入付款通知业务层实现
	 */
	@Autowired
	private IDrmPayNoticeService drmPayNoticeService;


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
        
        QueryParams<DrmPayNotice> queryParams=new QueryParams<DrmPayNotice>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmPayNotice> drmPayNoticeList = drmPayNoticeService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmPayNoticeList", drmPayNoticeList);

		return "drmpaynotice/pages/list";
	}
	
	/**
	 * 去新增付款通知
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmpaynotice/pages/add";
	}

	/**
	 * 新增付款通知
	 * 
	 * @param drmPayNoticeVo 付款通知页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmPayNoticeVo drmPayNoticeVo ){
		Integer id = -1;
		try{
			id = drmPayNoticeService.save(drmPayNoticeVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmpaynotice/detail/"+id;
	}

	/**
	 * 删除付款通知
	 * 
	 * @param id 付款通知页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmPayNoticeService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmpaynotice/list";
	}

	/**
	 * 去修改付款通知
	 * 
	 * @param id 付款通知页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmPayNotice drmPayNoticeEntity = (DrmPayNotice) drmPayNoticeService.getById(id);
				model.addAttribute("entity", drmPayNoticeEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmpaynotice/pages/update";
	}

	/**
	 * 修改付款通知
	 * 
	 * @param drmPayNoticeVo 付款通知页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmPayNoticeVo drmPayNoticeVo){
		try{
			drmPayNoticeService.update(drmPayNoticeVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmpaynotice/detail/"+ drmPayNoticeVo.getEntity().getId();
	}


	/**
	 * 跳转到付款通知详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmPayNotice com = (DrmPayNotice) drmPayNoticeService.getById(id);
		model.addAttribute("entity", com);
		return "drmpaynotice/pages/detail";
	}
}
