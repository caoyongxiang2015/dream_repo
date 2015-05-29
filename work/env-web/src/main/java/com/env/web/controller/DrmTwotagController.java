/**
 * Description: DrmTwotag控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:37:53
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
import com.env.dto.DrmTwotag;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmTwotagService;
import com.env.vo.DrmTwotagVo;


/**
 * DrmTwotag控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmtwotag")
public class DrmTwotagController extends BaseController {

	/**
	 * 自动注入DrmTwotag业务层实现
	 */
	@Autowired
	private IDrmTwotagService drmTwotagService;

	/**
	 * 获取二级标签列表
	 * @param onetagid
	 * @return
	 */
	@RequestMapping(value = "twotagSection/{onetagid}/{companyid}")
	public String twotagSection(@PathVariable Integer onetagid ,@PathVariable Integer companyid , Model model){
		
		PtUser user = (PtUser)UserUtils.getCurrentUser();
		List<DrmTwotag> twotags = drmTwotagService.getByUseridAndOnetagid(user.getId(), onetagid ,companyid);
		
		model.addAttribute("twotags", twotags);
		
		return "myhome/pages/twotagSection";
	}

	/**
	 * 选择/取消二级标签
	 * @param pk
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "toggletwotag/{pk}/{canprovide}")
	public String toggletwotag(@PathVariable Integer pk , @PathVariable Integer canprovide){
		drmTwotagService.toggletwotag(pk, canprovide);
		return "1";
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
        
        QueryParams<DrmTwotag> queryParams=new QueryParams<DrmTwotag>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmTwotag> drmTwotagList = drmTwotagService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmTwotagList", drmTwotagList);

		return "drmtwotag/pages/list";
	}
	
	/**
	 * 去新增DrmTwotag
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmtwotag/pages/add";
	}

	/**
	 * 新增DrmTwotag
	 * 
	 * @param drmTwotagVo DrmTwotag页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmTwotagVo drmTwotagVo ){
		Integer id = -1;
		try{
			id = drmTwotagService.save(drmTwotagVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmtwotag/detail/"+id;
	}

	/**
	 * 删除DrmTwotag
	 * 
	 * @param id DrmTwotag页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmTwotagService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmtwotag/list";
	}

	/**
	 * 去修改DrmTwotag
	 * 
	 * @param id DrmTwotag页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmTwotag drmTwotagEntity = (DrmTwotag) drmTwotagService.getById(id);
				model.addAttribute("entity", drmTwotagEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmtwotag/pages/update";
	}

	/**
	 * 修改DrmTwotag
	 * 
	 * @param drmTwotagVo DrmTwotag页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmTwotagVo drmTwotagVo){
		try{
			drmTwotagService.update(drmTwotagVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmtwotag/detail/"+ drmTwotagVo.getEntity().getId();
	}


	/**
	 * 跳转到DrmTwotag详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmTwotag com = (DrmTwotag) drmTwotagService.getById(id);
		model.addAttribute("entity", com);
		return "drmtwotag/pages/detail";
	}
}
