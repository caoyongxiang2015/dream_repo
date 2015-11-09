/**
 * Description: DrmNetfriendComment控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-11-09 下午 22:58:36
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-11-09   caoyx   1.0         Initial
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
import com.env.service.intf.IDrmNetfriendCommentService;

import com.env.dto.DrmNetfriendComment;
import com.env.vo.DrmNetfriendCommentVo;


/**
 * DrmNetfriendComment控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-11-09
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmnetfriendcomment")
public class DrmNetfriendCommentController extends BaseController {

	/**
	 * 自动注入DrmNetfriendComment业务层实现
	 */
	@Autowired
	private IDrmNetfriendCommentService drmNetfriendCommentService;


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
        
        QueryParams<DrmNetfriendComment> queryParams=new QueryParams<DrmNetfriendComment>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmNetfriendComment> drmNetfriendCommentList = drmNetfriendCommentService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmNetfriendCommentList", drmNetfriendCommentList);

		return "drmnetfriendcomment/pages/list";
	}
	
	/**
	 * 去新增DrmNetfriendComment
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmnetfriendcomment/pages/add";
	}

	/**
	 * 新增DrmNetfriendComment
	 * 
	 * @param drmNetfriendCommentVo DrmNetfriendComment页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmNetfriendCommentVo drmNetfriendCommentVo ){
		Integer id = -1;
		try{
			id = drmNetfriendCommentService.save(drmNetfriendCommentVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmnetfriendcomment/detail/"+id;
	}

	/**
	 * 删除DrmNetfriendComment
	 * 
	 * @param id DrmNetfriendComment页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmNetfriendCommentService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmnetfriendcomment/list";
	}

	/**
	 * 去修改DrmNetfriendComment
	 * 
	 * @param id DrmNetfriendComment页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmNetfriendComment drmNetfriendCommentEntity = (DrmNetfriendComment) drmNetfriendCommentService.getById(id);
				model.addAttribute("entity", drmNetfriendCommentEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmnetfriendcomment/pages/update";
	}

	/**
	 * 修改DrmNetfriendComment
	 * 
	 * @param drmNetfriendCommentVo DrmNetfriendComment页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmNetfriendCommentVo drmNetfriendCommentVo){
		try{
			drmNetfriendCommentService.update(drmNetfriendCommentVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmnetfriendcomment/detail/"+ drmNetfriendCommentVo.getEntity().getId();
	}


	/**
	 * 跳转到DrmNetfriendComment详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmNetfriendComment com = (DrmNetfriendComment) drmNetfriendCommentService.getById(id);
		model.addAttribute("entity", com);
		return "drmnetfriendcomment/pages/detail";
	}
}
