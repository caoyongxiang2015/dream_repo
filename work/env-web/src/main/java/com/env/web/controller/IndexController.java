package com.env.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.env.constant.Constants;
import com.env.dto.DrmLetter;
import com.env.dto.DrmPayNotice;
import com.env.dto.DrmReq;
import com.env.dto.DrmReqNotice;
import com.env.dto.PtUser;
import com.env.service.intf.IDrmLetterService;
import com.env.service.intf.IDrmPayNoticeService;
import com.env.service.intf.IDrmReqNoticeService;
import com.env.service.intf.IPtUserService;

@Controller
@RequestMapping()
public class IndexController {


	@Autowired
	private IDrmReqNoticeService<DrmReqNotice> drmReqNoticeService;


	@Autowired
	private IDrmPayNoticeService<DrmPayNotice> drmPayNoticeService;


	@Autowired
	private IPtUserService<PtUser> ptUserService;

	@Autowired
	private IDrmLetterService<DrmLetter> drmLetterService;
	
	public IndexController() {
	}

    @RequestMapping("/")
	public String index(HttpServletRequest request){

    	try{
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
		    	request.setAttribute("notices", notices);// 需求通知
	    	
		    	// 赏金待托管
		    	notice.setReceiveUserId(null);
		    	notice.setSendUserId(user.getId());// 我发出的需求
		    	List<DrmReqNotice> tuoguanTempNotices = drmReqNoticeService.queryByParams(notice);
		    	List<DrmReqNotice> tuoguanNotices = new ArrayList<DrmReqNotice> ();
		    	List<DrmReqNotice> serviceCompleteNotices = new ArrayList<DrmReqNotice> ();
	
		    	for(DrmReqNotice n : tuoguanTempNotices){
		    		DrmReq r = n.getReq();
		    		if(r!=null&&r.getAcceptState()!=null){
			    		if(r.getAcceptState().intValue()==1){// 已应答=待托管
			    			tuoguanNotices.add(n);
			    		}
			    		if(r.getAcceptState().intValue()==2){// 2赏金已托管3服务已完成
			    			serviceCompleteNotices.add(n);
			    		}
		    		}
		    	}
		    	
		    	request.setAttribute("tuoguanNotices", tuoguanNotices);// 托管赏金消息
		    	request.setAttribute("serviceCompleteNotices", serviceCompleteNotices);// 服务完成消息
		    	
		    	// 系统消息
		    	Map params = new HashMap();
		    	params.put("receiveUserid", user.getId());
		    	List<DrmLetter> sysletters = drmLetterService.getSysletter(params);
		    	request.setAttribute("sysletters", sysletters);// 
		    	
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return "index/pages/index";
	}

}
