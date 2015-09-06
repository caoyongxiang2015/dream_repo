package com.env.web.tags;


import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 工程令牌
 * 
 */
public class ProjectToken extends SimpleTagSupport {
    /**
     * (non-Javadoc)
     * 
     * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
     */
    @Override
    public void doTag() throws JspException, IOException {
        PageContext pc = (PageContext) this.getJspContext();
        JspWriter out = pc.getOut();
        AtomicLong token = new AtomicLong(System.currentTimeMillis());
        pc.getSession().setAttribute("token", token);
        out.println("<input type='hidden' value='" + token + "' id='token' name='token'/>");
    }
}