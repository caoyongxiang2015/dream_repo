package com.env.web.tags;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

public abstract class AbstractViewTag extends RequestContextAwareTag {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * 日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractViewTag.class);

    /**
     * 默认显示值
     */
    protected static final String DEFAULT_SHOW_VALUE = "";
    /**
     * 查询条件
     */
    protected Integer value;

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     * @param defaultShowValue the defaultShowValue to set
     */
    public void setDefaultShowValue(String defaultShowValue) {
        this.defaultShowValue = defaultShowValue;
    }

    /**
     * 默认展示的值
     */
    private Integer defaultValue;

    /**
     * 当查询条件和默认展示值一致时，展示的内容
     */
    private String defaultShowValue;

    @Override
    protected int doStartTagInternal() throws IOException {
        String showValue = "";
        // 如果value不为空则设置展示的值
        if (null != value) {
            // 如果默认值不为空，且默认值和查询条件一致则展示默认值展示内容
            if (null != defaultValue && defaultValue.equals(value)) {
                if (null != defaultShowValue) {
                    showValue = defaultShowValue;
                }
            } else {
                try {
                    showValue = getShowValue();
                } catch (Throwable ex) {
                    LOGGER.error("获取显示值失败", ex);
                }
            }
        }
        if (null == showValue) {
            pageContext.getOut().write("");
        } else {
            pageContext.getOut().write(showValue);
        }
        return SKIP_BODY;
    }

    /**
     * 设置查询条件
     * 
     * @param value 查询条件，一般为ID
     */
    public void setValue(Integer value) {
        this.value = value;
    }

    /**
     * 获取显示的内容
     * 
     * @return 显示的内容
     */
    protected abstract String getShowValue();

    /**
     * 获取Spring上下文
     * 
     * @return Spring上下文
     */
    protected WebApplicationContext getApplicationContext() {
        return getRequestContext().getWebApplicationContext();
    }

    /**
     * 获取资源信息
     * 
     * @return 资源信息
     */
    protected MessageSource getMessageSource() {
        return getRequestContext().getMessageSource();
    }
}