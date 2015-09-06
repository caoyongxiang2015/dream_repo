package com.env.web.annotation.interceptor;


import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.env.constant.Constants;
import com.env.web.annotation.NeedLogin;


/**
 * 自定义注解NeedLogin拦截机<br>
 */
public class AnnotationNeedLoginInterceptor extends HandlerInterceptorAdapter {
    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationNeedLoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean checkSuccess = false;
        // 已经登陆，直接设定验证OK
        if (null != request.getSession().getAttribute(Constants.SESSION_LOGINUSER)) {
            checkSuccess = true;
        } else {
            HandlerMethod hd = (HandlerMethod) handler;
            Method method = hd.getMethod();
            Class<?> controller = method.getDeclaringClass();
            LOGGER.debug("check need login with method: " + method);
            NeedLogin needLoginAnnotation = null;
            // 首先获取方法级别注解，（方法级别优于类级别）
            if (method.isAnnotationPresent(NeedLogin.class)) {
                needLoginAnnotation = method.getAnnotation(NeedLogin.class);
            } else if (controller.isAnnotationPresent(NeedLogin.class)) {
                needLoginAnnotation = controller.getAnnotation(NeedLogin.class);
            }
            // 如果注解存在，且设定为不需要登陆，则设定为验证OK（即：无配置默认需要登陆）
            if (null != needLoginAnnotation && !needLoginAnnotation.value()) {
                checkSuccess = true;
            }
        }
        if (!checkSuccess) {
            String requestUri = request.getRequestURI();
            String contextPath = request.getContextPath();
            // 设置跳转到登陆页
            response.sendRedirect(contextPath + "/login");
            // 设置登陆成功后跳回原页面
            request.getSession().setAttribute(Constants.REDIRECT_URL, requestUri.substring(contextPath.length()));
        }
        return checkSuccess;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
