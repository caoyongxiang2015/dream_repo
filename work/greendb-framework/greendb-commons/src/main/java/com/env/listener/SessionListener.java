package com.env.listener;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 监控服务端的session创建和销毁<br>
 * 
 */
public class SessionListener implements HttpSessionListener {

    ServletContext servletContext = null;

    /**
     */
    String sessionid = null;

 
    /**
     * {方法的功能/动作描述}
    
     * @param event
     * @exception   {说明在某情况下,将发生什么异常}
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        HttpSession httpSession = event.getSession();
        sessionid = httpSession.getId();
        servletContext = event.getSession().getServletContext();
        servletContext.log("session hava been created...the session id is:" + sessionid);
        servletContext.log("session isNew?:" + httpSession.isNew());
        servletContext.log("session creationTime:" + httpSession.getCreationTime());

    }

 
    /**
     * {方法的功能/动作描述}
    
     * @param event
     * @exception   {说明在某情况下,将发生什么异常}
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession httpSession = event.getSession();
        if (servletContext != null) {
            servletContext.log("session hava been destroyed...the session id is:" + sessionid
                    + "httpSession LastVisitTime:" + httpSession.getLastAccessedTime());
        }
    }

}
