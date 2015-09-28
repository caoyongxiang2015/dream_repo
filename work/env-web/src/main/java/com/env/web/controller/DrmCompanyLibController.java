/**
 * Description: 公司库，搜索使用控制器
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-22 下午 23:26:46
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-22   caoyx   1.0         Initial
 */
package com.env.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.constant.Constants;
import com.env.dto.DrmCompany;
import com.env.dto.DrmCompanyLib;
import com.env.dto.DrmSearchRecord;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmCompanyLibService;
import com.env.service.intf.IDrmCompanyService;
import com.env.service.intf.IDrmSearchRecordService;


/**
 * 公司库，搜索使用控制器<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-22
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/drmsearch")
public class DrmCompanyLibController extends BaseController {

	/**
	 * 自动注入公司库，搜索使用业务层实现
	 */
	@Autowired
	private IDrmCompanyLibService<DrmCompanyLib> drmCompanyLibService;

	@Autowired
	private IDrmCompanyService<DrmCompany> drmCompanyService;

	@Autowired
	private IDrmSearchRecordService<DrmSearchRecord> drmSearchRecordService;
	
	
    @RequestMapping()
	public String index(HttpServletRequest request){
    	
    	String name = request.getParameter("searchCompany");
    	
    	name = (null==name||"".equals(name.trim()))?null:name.trim();
    	
    	List<DrmCompanyLib> libs = (null==name||"".equals(name.trim()))?null:drmCompanyLibService.queryByParams(name);
    	
    	DrmCompany company = new DrmCompany();
		company.setCompanyName(name);
		company.setCompanyShotname(name);
		// 通过公司名称匹配到的记录数
//		List<DrmCompany> companys = (null==name||"".equals(name.trim()))?null:drmCompanyService.queryAllByParams(company);
		
//    	request.setAttribute("usercount", (companys==null)?0:companys.size());
		int contactUsernum = 0;
		if(libs!=null && libs.size()>0 && libs.get(0)!=null && libs.get(0).getContactUsernum()!=null){
			contactUsernum = libs.get(0).getContactUsernum();
		}
				
    	request.setAttribute("usercount", contactUsernum);
    	request.setAttribute("companyname", name);
    	request.setAttribute("company", (libs==null||libs.size()<1)?null:libs.get(0));
    	
    	PtUser user = (PtUser) request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
    	request.setAttribute("logined", (user==null)?0:1);// logined:未登录，1已登录
    	
    	// TODO 没有填写自己所在公司 or 没有登录的 ： 提醒用户登录并完善信息
    	
    	if(null!=user){// 已经登录
    		if(null==user.getCurCompanyName() || "".equals(user.getCurCompanyName())){
    			// 没有填写当前公司信息
    			request.setAttribute("hascurcompany", 0);// 		
    		}else{
    			request.setAttribute("hascurcompany", 1);// 		
    		}
    	}
    	if(null!=name&&!"".equals(name.trim())){
	    	//  记录搜索过的公司
	    	DrmSearchRecord entity = new DrmSearchRecord();
	    	entity.setCompanyName(name);
	    	entity.setSearchCount(1);
	    	drmSearchRecordService.save(entity);
    	}
    	
		return "drmsearch/pages/search";
	}
}
