package com.env.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springside.modules.web.Servlets;

import com.env.dao.api.Page;
import com.env.dao.api.QueryParams;
import com.env.dto.PtUser;
import com.env.service.intf.IPtUserService;

/**
 * [用户]控制器
 * @author caoyongxiang
 *
 */
//@NeedLogin(true)
@Controller
@RequestMapping("/userSample")
public class PtUserController {

    /**
     * 用户Service
     */
	@Autowired
	private IPtUserService<PtUser> envUserService;
	
	public PtUserController() {
	}

    // crud
	
	/**
	 * 用户列表
	 * @param number
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request,Integer number){
		return list( number, request, "user/pages/userList");
	}


	/**
	 * 第二种风格的userlist的url
	 * @param number
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list2")
	public String list2(Integer number, Model model, HttpServletRequest request){
		return list( number,   request, "user/pages/userList2");
	}
	
	private String list(Integer number , HttpServletRequest request, String returnPath){

        // 拿到所有的入参放到map里
//        Map<String, Object> searchParams = new HashMap<String, Object>();//Servlets.getParametersStartingWith(request, null);
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        
        Page page = new Page();
        
        if (null != number) {
            page.setCurrentPage(number);
            String pageSize = request.getParameter("pageSize");
            if(null != pageSize && !"".equals(pageSize)){
                page.setPageSize(Integer.parseInt(pageSize));
            }
        }
        
        QueryParams<PtUser> queryParams=new QueryParams<PtUser>();
        queryParams.setPaging(page);
        queryParams.setSearchParams(searchParams);
        
		List<PtUser> userList = envUserService.queryByPage(queryParams);
		
		request.setAttribute("page", page);
		request.setAttribute("searchParams", searchParams);
        request.setAttribute("userList", userList);
        
		return returnPath;
	}
	/**
	 * 用户详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/detail/{id}")
	public String detail(@PathVariable("id") Integer id, Model model){
		PtUser user = envUserService.getById(id);
		model.addAttribute("user", user);
		return "user/pages/userDetail";
	}

	@RequestMapping("/toAdd")
	public String toAdd(){
		return "user/pages/userAdd";
	}

	@RequestMapping("/add")
	public String add(PtUser user , Model model){
		user.setCompanyId(1);
		Integer id = envUserService.save(user);
		
		// TODO 导入测试数据到cfg_field_category表
		// envUserService.cfg_field_category(ReadTxt.imp());
		
		return "redirect:/userSample/detail/"+id;
	}


	@RequestMapping("/toEdit/{id}")
	public String toEdit(@PathVariable("id") Integer id, Model model){
		PtUser oldUser = envUserService.getById(id);
		model.addAttribute("user", oldUser);
		return "user/pages/userEdit";
	}

	@RequestMapping("/edit")
	public String edit(PtUser newUser){
		PtUser oldUser = envUserService.getById(newUser.getId());
		oldUser.setUsername(newUser.getUsername());
		envUserService.update(oldUser);
		return "redirect:/userSample/detail/"+newUser.getId();
	}

	@RequestMapping("/deleteById/{id}")
	public String deleteById(@PathVariable("id") Integer id){
		envUserService.delete(id);
		return "redirect:/userSample/list";
	}
	

}
