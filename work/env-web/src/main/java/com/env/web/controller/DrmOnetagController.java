/**
 * Description: DrmOnetag控制器
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
import com.env.dto.DrmOnetag;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmOnetagService;
import com.env.vo.DrmOnetagVo;


/**
 * DrmOnetag控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmonetag")
public class DrmOnetagController extends BaseController {

	/**
	 * 自动注入DrmOnetag业务层实现
	 */
	@Autowired
	private IDrmOnetagService drmOnetagService;

	@ResponseBody
	@RequestMapping(value = "getonetagid/{companyid}")
	public String getonetagid( @PathVariable Integer companyid){
		
		PtUser user = (PtUser)UserUtils.getCurrentUser();
		List<DrmOnetag> ls = drmOnetagService.getonetagid(user.getId(), companyid);
		
		StringBuffer buf = new StringBuffer();
		if(ls!=null && ls.size()>0){
			for(int i=0;i<ls.size();i++){
				DrmOnetag one = ls.get(i);
				buf.append(one.getId()).append(",");
			}
		}
		System.out.println(buf.toString());
		return buf.toString();
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
        
        QueryParams<DrmOnetag> queryParams=new QueryParams<DrmOnetag>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmOnetag> drmOnetagList = drmOnetagService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmOnetagList", drmOnetagList);

		return "drmonetag/pages/list";
	}
	
	/**
	 * 去新增DrmOnetag
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmonetag/pages/add";
	}

	/**
	 * 新增DrmOnetag
	 * 
	 * @param drmOnetagVo DrmOnetag页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmOnetagVo drmOnetagVo ){
		Integer id = -1;
		try{
			id = drmOnetagService.save(drmOnetagVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmonetag/detail/"+id;
	}

	/**
	 * 删除DrmOnetag
	 * 
	 * @param id DrmOnetag页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmOnetagService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmonetag/list";
	}

	/**
	 * 去修改DrmOnetag
	 * 
	 * @param id DrmOnetag页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmOnetag drmOnetagEntity = (DrmOnetag) drmOnetagService.getById(id);
				model.addAttribute("entity", drmOnetagEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmonetag/pages/update";
	}

	/**
	 * 修改DrmOnetag
	 * 
	 * @param drmOnetagVo DrmOnetag页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmOnetagVo drmOnetagVo){
		try{
			drmOnetagService.update(drmOnetagVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmonetag/detail/"+ drmOnetagVo.getEntity().getId();
	}


	/**
	 * 跳转到DrmOnetag详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmOnetag com = (DrmOnetag) drmOnetagService.getById(id);
		model.addAttribute("entity", com);
		return "drmonetag/pages/detail";
	}
}
