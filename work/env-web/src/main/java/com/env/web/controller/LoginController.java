//package com.env.web.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.env.commons.utils.MemoryPropertyPlaceholderConfigurer;
//import com.env.commons.utils.RegExpValidatorUtils;
//import com.env.constant.Constants;
//import com.env.dto.PtUser;
//import com.env.service.intf.IPtUserService;
//import com.env.web.annotation.NeedLogin;
//import com.google.gson.Gson;
//
///**
// * 登录
// * @author caoyongxiang
// *
// */
//@NeedLogin(false)
//@Controller
//public class LoginController {
//
//	/**
//	 * 用户接口
//	 */
//	@Autowired
//	private IPtUserService<?> envUserService;
//	
//	public LoginController() {
//	}
//
//	@RequestMapping("/login")
//    public String toLogin(){
//		return "index/pages/login";
//	}
//	
//	/**
//	 * 登陆
//	 * 前端ajax提交登陆申请，如果验证失败，则在前端页面显示错误信息，如果成功，前端页面跳转到redirect指定的页面
//	 * @param request
//	 * @param response
//	 * @param session
//	 * @return
//	 */
//    @RequestMapping("/verify")
//    @ResponseBody
//	public String verify(HttpServletRequest request, HttpServletResponse response, HttpSession session){
//    	    	
//    	Map<String, Object> map = verify( request,  session);
//    	
//    	if (map.size() < 1) {
//            String redirectUrl = (String) session.getAttribute(Constants.REDIRECT_URL);// redirectURL登陆拦截时设置
//            // 移除原请求视图属性
//            session.removeAttribute(Constants.REDIRECT_URL);
//            if (StringUtils.isEmpty(redirectUrl)) {
//                map.put(Constants.REDIRECT_URL, "/"); // 跳转到首页页
//            } else {
//                map.put(Constants.REDIRECT_URL, redirectUrl); // 跳转到原始访问页面
//            }
//        }
//        return new Gson().toJson(map);
//	}
//
//    /**
//     * 登陆验证
//     * @param request
//     * @param session
//     * @return
//     */
//    private Map<String, Object> verify(HttpServletRequest request, HttpSession session){
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        String username = request.getParameter(USERNAME);
//        String password = request.getParameter(PASSWORD);
//        // 验证码(忽略)
//        //String imgCode = request.getParameter("imgCode");
//        
//        // 验证用户名格式
//        if (RegExpValidatorUtils.isUserName(username)) {
//            if (!envUserService.isExistLoginid(username)) {
//            	
//            	String USERNAME_EXISTED = MemoryPropertyPlaceholderConfigurer.getContextProperty(
//            			Constants.USERNAME_EXISTED);
//            	
//                map.put(KEY, USERNAME);
//                map.put(MSG, USERNAME_EXISTED);
//                return map;
//            }
//        } else {
//        	String USERNAME_RULE_ERROR = MemoryPropertyPlaceholderConfigurer.getContextProperty(
//        			Constants.USERNAME_RULE_ERROR);
//            map.put(KEY, USERNAME);
//            map.put(MSG, USERNAME_RULE_ERROR);
//            return map;
//        }
//        //if (RegExpValidatorUtils.isPassWrod(password)) {
//        	PtUser loginUser= envUserService.loginUser(username, password);
//            if (null != loginUser) {
//                // 放入session
//                session.setAttribute(Constants.SESSION_LOGINUSER, loginUser);
//            } else {
//            	String USERNAME_OR_PWD_ERROR = MemoryPropertyPlaceholderConfigurer.getContextProperty(
//            			Constants.USERNAME_OR_PWD_ERROR);
//                map.put(KEY, PASSWORD);
//                map.put(MSG, USERNAME_OR_PWD_ERROR);
//                return map;
//            }
////        } else {
////        	String PASSWORD_RULE_ERROR = MemoryPropertyPlaceholderConfigurer.getContextProperty(
////        			Constants.PASSWORD_RULE_ERROR);
////            map.put(KEY, PASSWORD);
////            map.put(MSG, PASSWORD_RULE_ERROR);
////            return map;
////        }
//        return map;
//    
//    }
//
//    
//    /**
//     * 退出
//     * @param session
//     * @return
//     */
//    @RequestMapping("/logout")
//    @ResponseBody
//	public String logout(HttpSession session){
//    	session.removeAttribute(Constants.SESSION_LOGINUSER);
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put(Constants.REDIRECT_URL, "/login"); // 跳转到登录页
//        return new Gson().toJson(map);
//	}
//    
//    
//    /** 常量定义区 start */
//	public static final String USERNAME="username";
//	public static final String PASSWORD="password";
//	public static final String MSG="msg";
//	public static final String KEY="key";
//    /** 常量定义区 end */
//	
//}
