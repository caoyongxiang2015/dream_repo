package com.env.web.controller;

	
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.env.commons.utils.JsonUtils;
import com.env.commons.utils.RegExpValidatorUtils;
import com.env.commons.utils.StringUtils;
import com.env.constant.Constants;
import com.env.dto.PtRoleUser;
import com.env.dto.PtUser;
import com.env.service.intf.IPtRoleUserService;
import com.env.service.intf.IPtUserService;
import com.env.util.MobileValidateCodeUtil;
import com.env.util.SmsSender;
import com.env.util.bean.MobileValidateCodeCheckResult;
	  
/**
 * 登陆认证的控制器
 * @author caoyongxiang
 *
 */
@Controller  
@RequestMapping("/auth")  
public class AuthLoginController {  

    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthLoginController.class);

    @Autowired
    SmsSender smsSender;
    
    @Autowired
    IPtUserService<PtUser> ptUserService;

    @Autowired
    IPtRoleUserService<PtRoleUser> ruService;
    
	@RequestMapping("/toLogin")
    public String toLogin(){
		//return "index/pages/auth_login";
		return "redirect:/";// 跳到首页
	}
	
    /** 
     * 用户登录 
     */  
    @RequestMapping(value="/login", method=RequestMethod.POST)  
    public String login(HttpServletRequest request){  
        String username = request.getParameter("username");  
        String password = request.getParameter("password");  
        String rememberMe = request.getParameter("rememberMe");  
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
        token.setRememberMe(null!=rememberMe);  
        LOGGER.debug("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        //获取当前的Subject  
        Subject currentUser = SecurityUtils.getSubject();  
        String successToUrl = "/";
        try {  
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
            LOGGER.info("对用户[" + username + "]进行登录验证..验证开始");
            
            currentUser.login(token);  
            
            LOGGER.info("对用户[" + username + "]进行登录验证..验证通过");
            
            successToUrl = "/profile";// 登录成功后去我的资料页面
            
        }catch(UnknownAccountException uae){  
            LOGGER.warn("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            request.setAttribute("message_login", "未知账户");  
        }catch(IncorrectCredentialsException ice){  
        	LOGGER.warn("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            request.setAttribute("message_login", "密码不正确");  
        }catch(LockedAccountException lae){  
        	LOGGER.warn("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            request.setAttribute("message_login", "账户已锁定");  
        }catch(ExcessiveAttemptsException eae){  
        	LOGGER.warn("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            request.setAttribute("message_login", "用户名或密码错误次数过多");  
        }catch(AuthenticationException ae){  
        	//通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
        	LOGGER.warn("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
            ae.printStackTrace();  
            request.setAttribute("message_login", "用户名或密码不正确");  
        }  
        //验证是否登录成功  
        if(currentUser.isAuthenticated()){  
        	LOGGER.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
        }else{  
            token.clear();  
        }  
        // 登录成功后页面跳转
		HttpSession session = request.getSession();
		// redirectUrl 原始URL（登录前URL）
        String redirectUrl = (String) session.getAttribute(Constants.REDIRECT_URL);// redirectURL登陆拦截时设置
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + ((null==redirectUrl)? successToUrl : redirectUrl);
    }  
     
    @ResponseBody
    @RequestMapping(value="/ajaxlogin", method=RequestMethod.POST ,produces = "application/json; charset=utf-8")  
    public String ajaxlogin(HttpServletRequest request){  
    	String username = request.getParameter("username");  
    	String password = request.getParameter("password");  
    	String rememberMe = request.getParameter("rememberMe");  
    	UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
    	token.setRememberMe(null!=rememberMe);  
    	LOGGER.debug("为了验证登录用户而封装的token为" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
    	//获取当前的Subject  
    	Subject currentUser = SecurityUtils.getSubject();  
    	String loginSuccess = "1";
    	try {  
    		//在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查  
    		//每个Realm都能在必要时对提交的AuthenticationTokens作出反应  
    		//所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法  
    		LOGGER.info("对用户[" + username + "]进行登录验证..验证开始");
    		
    		currentUser.login(token);  
    		
    		LOGGER.info("对用户[" + username + "]进行登录验证..验证通过");
    		
    		
    	}catch(UnknownAccountException uae){  
    		LOGGER.warn("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
    		request.setAttribute("message_login", "未知账户");  
    	}catch(IncorrectCredentialsException ice){  
    		LOGGER.warn("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
    		request.setAttribute("message_login", "密码不正确");  
    	}catch(LockedAccountException lae){  
    		LOGGER.warn("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
    		request.setAttribute("message_login", "账户已锁定");  
    	}catch(ExcessiveAttemptsException eae){  
    		LOGGER.warn("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
    		request.setAttribute("message_login", "用户名或密码错误次数过多");  
    	}catch(AuthenticationException ae){  
    		//通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景  
    		LOGGER.warn("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
    		ae.printStackTrace();  
    		request.setAttribute("message_login", "用户名或密码不正确");  
    	}  
    	//验证是否登录成功  
    	if(currentUser.isAuthenticated()){  
    		LOGGER.info("用户[" + username + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
    	}else{  
    		token.clear();  
    		loginSuccess = "0";
    	}  
    	Map<String,Object> rtn = new HashMap<String,Object> ();
    	rtn.put("loginSuccess", loginSuccess);
    	String message_login = (String)request.getAttribute("message_login") ;
    	rtn.put("loginMsg", message_login);
    	
    	return JsonUtils.toJson(rtn);
    }  
    
      
    /** 
     * 用户登出 
     */  
    @RequestMapping("/logout")  
    public String logout(HttpServletRequest request){  
         SecurityUtils.getSubject().logout();  
//         return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/auth/toLogin";  
         return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/";// go to index  
    }  
    
    /**
     * 跳转到授权提示页面
     * @return
     */
	@RequestMapping("/author")
    public String author(){
		return "index/pages/author";
	}

	/**
	 * 跳转到未授权提示页面
	 * @return
	 */
	@RequestMapping("/unauthor")
    public String unauthor(){
		return "index/pages/unauthor";
	}
	
	
	
	//===========================================================================
	
	/**
	 * 用户注册
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/register/userRegister", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String userRegister(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Map<String, Object> map = checkRegisterAll(request, session);
        if (map.size() < 1) {
        	map = checkRegisterPhoneCode(request, session);
        }
        if (map.size() < 1) {
            String phone = request.getParameter("phone");
            String pwd = request.getParameter("pwd");
            
            PtUser user = new PtUser();
            user.setPhone(phone);
            user.setLoginId(phone);
            user.setPwd(pwd);
            
            Integer id = 0;
            try{
            	id = ptUserService.save(user);
            	request.getSession().setAttribute(Constants.SESSION_LOGINUSER,user);
                map.put("result", true);
                map.put("message", "注册成功");
                
                // 赋予权限
                // v0.2版本不设置权限，默认全有
                PtRoleUser ru = new PtRoleUser();
                ru.setRoleId(2);
                ru.setUserId(id);
                ruService.save(ru);
                
            }catch(Exception e){
            	e.printStackTrace();
                map.put("result", false);
                map.put("message", "注册失败");
            }
            
            if (id < 1) {
                map.put("result", false);
                map.put("message", "注册失败");
            }
        }else{
        	map.put("result", false);
        }
        
        return JsonUtils.toJson(map);
    }
	
	 /**
     * 
     * 功能描述: 获取手机验证码
     * 
     * @param session 会话
     * @return 展示视图
     */
    @RequestMapping(value = "/register/getCode", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getCode(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        map = checkRegisterAll(request, session);// 校验
        if (map.size() < 1) {
	        map.put("result", false);
	        map.put("message", "短信发送失败!");
	        try {
	            String phone = request.getParameter("phone");
	            int type = Integer.parseInt(request.getParameter("type"));
	            if (RegExpValidatorUtils.isPhone(phone)) {
	                
	                // 创建手机验证码（已放入session）
	                String code = MobileValidateCodeUtil.setMobileValidateCode(session);
	                StringBuffer content = new StringBuffer();
	                switch (type) {
	                    case 1:// 注册
	                        content.append("您正在注册好职客会员,手机验证码").append(code).append(",有效期120秒");
	                        break;
	                    case 2:// 找回密码
	                        content.append("您正在找回密码，手机动态密码").append(code).append("，有效期120秒(工作人员不会向您索要，请勿向任何人泄露)");
	                        break;
	                    case 3:// 修改手机号码
	                        content.append("您正在修改手机号码，手机动态密码").append(code).append("，有效期120秒(工作人员不会向您索要，请勿向任何人泄露)");
	                        break;
	                    default:
	                        break;
	                }
	                // 发送验证码
	                if (smsSender.sendSms(phone, content.toString())) {
	                    map.put("result", true);
	                    map.put("message", "短信已发送!");
	                }
	            }
	        } catch (Exception e) {
	            LOGGER.error("getCode", e.getMessage());
	            e.printStackTrace();
	        }
        }else{
        	map.put("result", false);
        }
        return JsonUtils.toJson(map);
//        return new Gson().toJson(map);

    }

	
    

    /**
     * 注册时后台验证方法
     * 
     * @param request
     * @return
     */
    private Map<String, Object> checkRegisterAll(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        String password = request.getParameter("pwd");
        String phone = request.getParameter("phone");
        String authCode = request.getParameter("authCode");
//        String email = request.getParameter("email");
        
        if (StringUtils.isNotBlank(phone)) {
            if (RegExpValidatorUtils.isPhone(phone)) {
                /*if (!myAccountService.checkPhone(phone)) {
                    map.put("key", "phone");
                    map.put("message", "手机号已存在");
                    return map;
                }*/
            	if (ptUserService.isExistLoginid(phone)) {
                    map.put("key", "phone");
                    map.put("message", "手机号码已存在");
                    return map;
                }
            } else {
                map.put("key", "phone");
                map.put("message", "手机号码非正常手机号码");
                return map;
            }
        } else {
            map.put("key", "phone");
            map.put("message", "手机号为空");
            return map;
        }
        
        if (StringUtils.isNotBlank(password)) {
            /*if (RegExpValidatorUtils.isPassWrod(password)) {
                if (RegExpValidatorUtils.isPassWrod(newPassword)) {
                    if (!newPassword.equals(password)) {
                        map.put("key", "newPassword");
                        map.put("message", "两次输入密码不一致");
                        return map;
                    }
                } else {
                    map.put("key", "newPassword");
                    map.put("message", "6-18位数字字母组合");
                    return map;
                }
            } else {
                map.put("key", "password");
                map.put("message", "6-18位数字字母组合");
                return map;
            }*/
        } else {
            map.put("key", "password");
            map.put("message", "密码为空");
            return map;
        }
        
/*        if (StringUtils.isNotBlank(email)) {
            if (RegExpValidatorUtils.isEmail(email)) {
                if (!myAccountService.checkEmail(email)) {
                    map.put("key", "email");
                    map.put("message", "email已存在");
                    return map;
                }
            } else {
                map.put("key", "email");
                map.put("message", "email格式不正确");
                return map;
            }
        } else {
            map.put("key", "email");
            map.put("message", "email为空");
            return map;
        }
*/        
/*
        if (StringUtils.isNotBlank(authCode)) {
            MobileValidateCodeCheckResult result = MobileValidateCodeUtil.checkMobileValidateCode(session, authCode);
            if (!result.isCheckStatus()) {
                map.put("key", "authCode");
                map.put("message", result.getCheckMessage());
                return map;
            }
        } else {
            map.put("key", "authCode");
            map.put("message", "手机验证码为空");
            return map;
        }
        */
        return map;
    }
    /**
     * 手机验证码校验
     * @param request
     * @param session
     * @return
     */
    private Map<String, Object> checkRegisterPhoneCode(HttpServletRequest request, HttpSession session) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	String authCode = request.getParameter("authCode");
    	 
    	 if (StringUtils.isNotBlank(authCode)) {
    		 MobileValidateCodeCheckResult result = MobileValidateCodeUtil.checkMobileValidateCode(session, authCode);
    		 if (!result.isCheckStatus()) {
    			 map.put("key", "authCode");
    			 map.put("message", result.getCheckMessage());
    			 return map;
    		 }
    	 } else {
    		 map.put("key", "authCode");
    		 map.put("message", "手机验证码为空");
    		 return map;
    	 }
    	 return map;
    }

	
}  