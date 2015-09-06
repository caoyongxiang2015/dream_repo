/**
 * Description: 给哪些用户发需求通知，我接收到的需求控制器
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
import com.env.service.intf.IDrmReqNoticeService;

import com.env.dto.DrmReqNotice;
import com.env.vo.DrmReqNoticeVo;


/**
 * 给哪些用户发需求通知，我接收到的需求控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmreqnotice")
public class DrmReqNoticeController extends BaseController {

	/**
	 * 自动注入给哪些用户发需求通知，我接收到的需求业务层实现
	 */
	@Autowired
	private IDrmReqNoticeService drmReqNoticeService;


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
        
        QueryParams<DrmReqNotice> queryParams=new QueryParams<DrmReqNotice>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmReqNotice> drmReqNoticeList = drmReqNoticeService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmReqNoticeList", drmReqNoticeList);

		return "drmreqnotice/pages/list";
	}
	
	/**
	 * 去新增给哪些用户发需求通知，我接收到的需求
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmreqnotice/pages/add";
	}

	/**
	 * 新增给哪些用户发需求通知，我接收到的需求
	 * 
	 * @param drmReqNoticeVo 给哪些用户发需求通知，我接收到的需求页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmReqNoticeVo drmReqNoticeVo ){
		Integer id = -1;
		try{
			id = drmReqNoticeService.save(drmReqNoticeVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmreqnotice/detail/"+id;
	}

	/**
	 * 删除给哪些用户发需求通知，我接收到的需求
	 * 
	 * @param id 给哪些用户发需求通知，我接收到的需求页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmReqNoticeService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmreqnotice/list";
	}

	/**
	 * 去修改给哪些用户发需求通知，我接收到的需求
	 * 
	 * @param id 给哪些用户发需求通知，我接收到的需求页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmReqNotice drmReqNoticeEntity = (DrmReqNotice) drmReqNoticeService.getById(id);
				model.addAttribute("entity", drmReqNoticeEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmreqnotice/pages/update";
	}

	/**
	 * 修改给哪些用户发需求通知，我接收到的需求
	 * 
	 * @param drmReqNoticeVo 给哪些用户发需求通知，我接收到的需求页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmReqNoticeVo drmReqNoticeVo){
		try{
			drmReqNoticeService.update(drmReqNoticeVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmreqnotice/detail/"+ drmReqNoticeVo.getEntity().getId();
	}


	/**
	 * 跳转到给哪些用户发需求通知，我接收到的需求详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmReqNotice com = (DrmReqNotice) drmReqNoticeService.getById(id);
		model.addAttribute("entity", com);
		return "drmreqnotice/pages/detail";
	}
}
