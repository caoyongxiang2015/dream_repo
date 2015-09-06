package com.env.web.tags;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FlushMessageTag extends TagSupport {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private static final String DIV_STR = "</div>";

    @Override
    public int doEndTag() throws JspException {
        ServletRequest servletRequest = this.pageContext.getRequest();
        String message = (String) servletRequest.getAttribute("message");
        @SuppressWarnings("unchecked")
        List<AlertMessageObject> messages = new ArrayList<AlertMessageObject>();
        @SuppressWarnings("unchecked")
        List<AlertMessageObject> errors = new ArrayList<AlertMessageObject>();
        try {

            messages = (List<AlertMessageObject>) servletRequest.getAttribute("messages");

            errors = (List<AlertMessageObject>) servletRequest.getAttribute("errors");
        } catch (Exception e) {

        }

        StringBuilder sb = new StringBuilder();
        if (message != null && message.length() > 0) {
            sb.append("<div class='alert alert-success'>");
            sb.append("<i class='icon-remove close' data-dismiss='alert'></i>");
            sb.append(message);
            sb.append(DIV_STR);
        }
        boolean hasError = errors != null && errors.size() > 0;
        if (hasError) {
            sb.append("<div class='alert alert-error'>");
            sb.append("<i class='icon-remove close' data-dismiss='alert'></i>");
            sb.append("<ul class='error_container'>");
            for (AlertMessageObject errorObject : errors) {
                sb.append("<li>");
                sb.append(errorObject.getMessage());
                sb.append("</li>");
            }
            sb.append("</ul>");
            sb.append(DIV_STR);
        }

        boolean hasMessages = (null != messages && !messages.isEmpty());
        if (hasMessages) {
            for (AlertMessageObject messageObject : messages) {
                sb.append("<div class='alert ");
                sb.append(messageObject.getLevel().getClassName());
                sb.append("'>");
                sb.append("<i class='icon-remove close' data-dismiss='alert'></i>");
                sb.append(messageObject.getMessage());
                sb.append(DIV_STR);
            }
        }
        // 如果长度不为空,则整体下移50px
        if (0 < sb.length()) {
            sb.insert(0, "<div>");
            sb.append(DIV_STR);
        }
        try {
            this.pageContext.getOut().write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}