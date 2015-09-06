package com.env.listener.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

public class ApplicationContextListener implements
        ApplicationListener<ApplicationEvent> {
    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ApplicationContextListener.class);

    /*
     * <bean id="ApplicationEventListener"
     * class="org.env.listener.event.ServletContextListener" />
     */

    /**
     * {方法的功能/动作描述}
     * 
     * @param event
     * @exception {说明在某情况下,将发生什么异常}
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextClosedEvent) {
            LOGGER.info(event.getClass().getSimpleName() + "容器关闭了...");
        } else if (event instanceof ContextStartedEvent) {
            LOGGER.info(event.getClass().getSimpleName() + " 启动了...");
        } else if (event instanceof ContextRefreshedEvent) {
            LOGGER.info(event.getClass().getSimpleName() + " 容器刷新了...");
        } else if (event instanceof ContextStoppedEvent) {
            // 发送邮件
            LOGGER.info(event.getClass().getSimpleName() + "容器关闭了...");
        } else {
            LOGGER.debug("Context Other:" + event.getClass().getName());
        }
    }
}
