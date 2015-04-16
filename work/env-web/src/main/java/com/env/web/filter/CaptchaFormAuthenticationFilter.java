package com.env.web.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import com.env.constant.Constants;

/**
 * 所有被拦截的请求都会经过的方法
 * 2014.12.5
 * @author caoyongxiang
 * @since 1.0
 */
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

	/**
	 * 不拦截auth/toLogin这个URL
	 */
	public boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

		HttpServletRequest httpservletrequest = (HttpServletRequest) request;
		HttpSession session = httpservletrequest.getSession();
		
		String resUrl = httpservletrequest.getServletPath();
		if (resUrl.indexOf("/toLogin") < 0) {// 非登录的URL，说明是从其他URL未授权情况下跳转到登录URL
			// 初始化历史记录栈
//			LinkedList<String> historyUrlList = (LinkedList<String>) httpservletrequest
//					.getSession().getAttribute("historyUrlList");
//			
//			historyUrlList.addFirst(resUrl);
//			
//			httpservletrequest.getSession().setAttribute("historyUrlList", historyUrlList);

			String queryString = httpservletrequest.getQueryString();
			String redirectUrl = (queryString==null||"".equals(queryString.trim())) ? resUrl:(resUrl + "?" + queryString);
			
			session.setAttribute(Constants.REDIRECT_URL, redirectUrl);
		}
		
		saveRequestAndRedirectToLogin(request, response);// 跳转到login页

		return false;
	}
}
