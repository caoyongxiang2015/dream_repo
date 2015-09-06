/**
 * Description: 需求控制器
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.constant.Constants;
import com.env.dao.api.Page;
import com.env.dao.api.QueryParams;
import com.env.dto.DrmReq;
import com.env.dto.DrmReqNotice;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmReqNoticeService;
import com.env.service.intf.IDrmReqService;
import com.env.vo.DrmReqVo;


/**
 * 需求控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmreq")
public class DrmReqController extends BaseController {

	/**
	 * 自动注入需求业务层实现
	 */
	@Autowired
	private IDrmReqService drmReqService;

	@Autowired
	private IDrmReqNoticeService<DrmReqNotice> drmReqNoticeService;

    @RequestMapping()
	public String index(HttpServletRequest request){
    	
    	PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
    	DrmReqNotice notice = new DrmReqNotice();
    	
    	notice.setReceiveUserId((user==null)?0:user.getId());
    	// TODO 
    	// 1 drm_req_notice  我接收到的需求
    	// 2 drm_req 需求的信息：如金额，公司名称
    	List<DrmReqNotice> notices = drmReqNoticeService.queryByParams(notice);
    	
    	
    	// 3 私信
    	// 4
    	
    	
    	request.setAttribute("notices", notices);
    	
		return "drmreq/pages/req";
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
        
        QueryParams<DrmReq> queryParams=new QueryParams<DrmReq>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmReq> drmReqList = drmReqService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmReqList", drmReqList);

		return "drmreq/pages/list";
	}
	
	/**
	 * 去新增需求
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmreq/pages/add";
	}

	/**
	 * 新增需求
	 * 
	 * @param drmReqVo 需求页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmReqVo drmReqVo ){
		Integer id = -1;
		try{
			id = drmReqService.save(drmReqVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmreq/detail/"+id;
	}

	/**
	 * 删除需求
	 * 
	 * @param id 需求页面表单对象唯一标识
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "delete/{id}")
	public String delete (@PathVariable("id") Integer id, Page page, HttpServletRequest request){
		try{
			if(null != id){
			    drmReqService.delete(id);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmreq/list";
	}

	/**
	 * 去修改需求
	 * 
	 * @param id 需求页面表单对象唯一标识
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "toedit/{id}")
	public String toedit(@PathVariable("id") Integer id , Model model){
		try{
			if(null != id){
				DrmReq drmReqEntity = (DrmReq) drmReqService.getById(id);
				model.addAttribute("entity", drmReqEntity);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "drmreq/pages/update";
	}

	/**
	 * 修改需求
	 * 
	 * @param drmReqVo 需求页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "update")
	public String update (DrmReqVo drmReqVo){
		try{
			drmReqService.update(drmReqVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmreq/detail/"+ drmReqVo.getEntity().getId();
	}


	/**
	 * 跳转到需求详情页面
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "detail/{id}")
	public String detail(@PathVariable Integer id, Model model) {
		DrmReq com = (DrmReq) drmReqService.getById(id);
		model.addAttribute("entity", com);
		return "drmreq/pages/detail";
	}
}
