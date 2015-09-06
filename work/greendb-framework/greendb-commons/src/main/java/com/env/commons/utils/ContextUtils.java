package com.env.commons.utils;


/**
 * 
 */

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 上下文工具<br>
 * <font color="red">必须保证ServletContext监听正常启动并且赋值到该对象方能使用</font>
 * 
 */
public class ContextUtils {
    /**
     * Web应用上下文(ServletContext)
     */
    private static ServletContext application;
    /**
     * Spring上下文(ApplicationContext)
     */
    private static ApplicationContext applicationContext;

    /**
     * 获取Web应用上下文(ServletContext)
     * 
     * @return Web应用上下文(ServletContext)
     */
    public static ServletContext getApplication() {
        return application;
    }

    /**
     * 设置Web应用上下文(ServletContext)及Spring上下文(ApplicationContext)
     * 
     * @param application
     *            Web应用上下文(ServletContext)
     */
    public synchronized static void setApplication(ServletContext application) {
        if (null == ContextUtils.application) {
            ContextUtils.application = application;
            ContextUtils.applicationContext = WebApplicationContextUtils
                    .getWebApplicationContext(application);
        }
    }

    /**
     * 获取Spring上下文(ApplicationContext)
     * 
     * @return Spring上下文(ApplicationContext)
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * 设置Spring上下文(ApplicationContext)
     * 
     * @param applicationContext
     *            Spring上下文(ApplicationContext)
     */
    public synchronized static void setApplicationContext(
            ApplicationContext applicationContext) {
        if (null == ContextUtils.applicationContext) {
            ContextUtils.applicationContext = applicationContext;
        }
    }
}
