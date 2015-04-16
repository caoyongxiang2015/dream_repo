package com.env.web.tags;


/**
 * 弹窗信息级别
 * 
 */
public enum AlertMessageLevel {
    /**
     * INFO级别信息，显示为蓝色
     */
    INFO("alert-info"),
    /**
     * SUCCESS级别信息，显示为绿色
     */
    SUCCESS("alert-success"),
    /**
     * WARN级别信息，显示为橙色
     */
    WARN("alert-block"),
    /**
     * ERROR级别信息，显示为红色
     */
    ERROR("alert-error"),
    /**
     * 默认级别信息，同WARN级别
     */
    DEFAULT("alert");
    /**
     * 样式名称
     */
    private final String className;

    /**
     * 弹窗消息级别构造器
     * 
     * @param classValue
     *            级别对应的页面class名称
     */
    AlertMessageLevel(String classValue) {
        this.className = classValue;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }
}
