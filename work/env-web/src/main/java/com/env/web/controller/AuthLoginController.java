package com.env.web.controller;

	
import javax.servlet.http.HttpServletRequest;  
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
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.servlet.view.InternalResourceViewResolver;  

import com.env.constant.Constants;
	  
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

	@RequestMapping("/toLogin")
    public String toLogin(){
		return "index/pages/auth_login";
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
        }  
        // 登录成功后页面跳转
		HttpSession session = request.getSession();
		// redirectUrl 原始URL（登录前URL）
        String redirectUrl = (String) session.getAttribute(Constants.REDIRECT_URL);// redirectURL登陆拦截时设置
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX + ((null==redirectUrl)? "/profile":redirectUrl);
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
}  