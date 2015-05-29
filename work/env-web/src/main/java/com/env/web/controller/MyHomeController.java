package com.env.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.commons.utils.UserUtils;
import com.env.dao.api.QueryParams;
import com.env.dto.DrmCompany;
import com.env.dto.PtUser;
import com.env.service.DrmCompanyService;

/**
 * 我的主页
 * @author caoyongxiang
 *
 */
@Controller
@RequestMapping("/myhome")
public class MyHomeController {

	@Autowired
	private DrmCompanyService<DrmCompany> drmCompanyService;
	
	public MyHomeController() {
	}

    @RequestMapping("")
	public String index(Model model){
    	//登录用户
    	PtUser user = (PtUser)UserUtils.getCurrentUser();
    	
    	//获取公司列表
    	List<DrmCompany> companys = drmCompanyService.queryAllByUserid(user.getId());
    	
    	model.addAttribute("companys",companys);
		return "myhome/pages/homepage";
	}

    
    
}
