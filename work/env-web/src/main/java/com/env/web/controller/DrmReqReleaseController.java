/**
 * Description: 控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:47
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
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.dao.api.Page;
import com.env.dao.api.QueryParams;
import com.env.dto.DrmDept;
import com.env.service.intf.IDrmDeptService;
import com.env.vo.DrmDeptVo;


/**
 * 需求发布五部曲<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-29
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/release")
public class DrmReqReleaseController extends BaseController {

	/**
	 * 自动注入用户注册的部门信息业务层实现
	 */
	@Autowired
	private IDrmDeptService drmDeptService;


    @RequestMapping(value="first")
	public String first(){
		return "drmreqrelease/pages/release1";
	}

    @RequestMapping(value="second")
	public String second(){
		return "drmreqrelease/pages/release2";
	}

    @RequestMapping(value="third")
	public String third(){
		return "drmreqrelease/pages/release3";
	}

    @RequestMapping(value="forth")
	public String forth(){
		return "drmreqrelease/pages/release4";
	}

    @RequestMapping(value="fifth")
	public String fifth(){
		return "drmreqrelease/pages/release5";
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
        
        QueryParams<DrmDept> queryParams=new QueryParams<DrmDept>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<DrmDept> drmDeptList = drmDeptService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("drmDeptList", drmDeptList);

		return "drmdept/pages/list";
	}
	
	/**
	 * 去新增用户注册的部门信息
	 * 
	 * @return 结果视图
	 */
	@RequestMapping(value = "toadd")
	public String toadd(){
		return "drmdept/pages/add";
	}

	/**
	 * 新增用户注册的部门信息
	 * 
	 * @param drmDeptVo 用户注册的部门信息页面表单对象
	 * @param result 表单验证数据
	 * @param page 分页配置
	 * @param request 请求对象
	 * @return 结果视图
	 */
	@RequestMapping(value = "save")
	public String save (DrmDeptVo drmDeptVo ){
		Integer id = -1;
		try{
			id = drmDeptService.save(drmDeptVo.getEntity());
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/drmdept/detail/"+id;
	}

}
