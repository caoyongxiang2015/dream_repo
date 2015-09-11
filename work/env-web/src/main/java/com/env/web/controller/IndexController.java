package com.env.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.constant.Constants;
import com.env.dto.DrmReq;
import com.env.dto.DrmReqNotice;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmReqNoticeService;
import com.env.web.annotation.NeedLogin;

@NeedLogin(false)
@Controller
@RequestMapping()
public class IndexController {


	@Autowired
	private IDrmReqNoticeService<DrmReqNotice> drmReqNoticeService;

	
	public IndexController() {
	}

    @RequestMapping("/")
	public String index(HttpServletRequest request){
    	System.out.println("IndexController");

    	PtUser user = (PtUser)request.getSession().getAttribute(Constants.SESSION_LOGINUSER);
    	if(null!=user){
    		// 已登录的用户
	    	// ================ 我收到的需求 ====================
	    	DrmReqNotice notice = new DrmReqNotice();
	    	
	    	notice.setReceiveUserId(user.getId());
	    	// TODO 
	    	// 1 drm_req_notice  我接收到的需求
	    	// 2 drm_req 需求的信息：如金额，公司名称
	    	List<DrmReqNotice> tempNotices = drmReqNoticeService.queryByParams(notice);
	    	List<DrmReqNotice> notices = new ArrayList<DrmReqNotice> ();
	    	
	    	//未被应答
	    	for(DrmReqNotice n : tempNotices){
	    		DrmReq r = n.getReq();
	    		if(r!=null&&r.getAcceptState()!=null){
		    		if(r.getAcceptState().intValue()==0){
		    			notices.add(n);
		    		}
	    		}
	    	}
	    	
	    	request.setAttribute("cur_userid", user.getId());
	    	request.setAttribute("notices", notices);
    	}
    	
		return "index/pages/index";
	}

}
