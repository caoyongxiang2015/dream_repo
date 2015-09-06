package com.env.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContextException;

public class InitialCacheListener implements ServletContextListener {
    /**
     */
    public static final String CONFIG_CACHE_PARAM = "isCreateCache";
    
    /**
     */
    public ServletContext servletContext;

    /**
     * {方法的功能/动作描述}
    
     * @param arg0
     * @exception   {说明在某情况下,将发生什么异常}
     */
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        servletContext.log("Destroyed project cache ServletContext");
    }

  
    /**
     * {方法的功能/动作描述}
    
     * @param event
     * @exception   {说明在某情况下,将发生什么异常}
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            servletContext = event.getServletContext();
            servletContext.log("Initializing project cache ServletContext");
            String initParam = servletContext.getInitParameter(CONFIG_CACHE_PARAM);
            if (initParam != null) {
                servletContext.log("Get the initparam value is " + initParam);
            }
        } catch (Exception ex) {
            throw new ApplicationContextException(ex.getMessage(), ex);
        }
    }

}
