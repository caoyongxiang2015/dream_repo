package com.env.web.tags;


import java.io.IOException;

import org.springframework.context.MessageSource;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.env.dao.api.Page;


/**
 * 分页标签
 * 
 */
public class PaginationTag extends RequestContextAwareTag {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private static final String DIV_STR = "</div>";
    private static final String A_LI_STR = "</a></li>";
    // 总数
    private long totalElements;
    // 每页数量
    private int size;
    // 总页数
    private int totalPages;
    // 当前页数
    private int number;

    private int showBefore = 3;

    private boolean hideInfo;

    public void setPage(Page page) {
        this.totalElements = page.getRecords();
        this.size = page.getPageSize();
        this.totalPages = page.getPages();
        // page 对象的number默认从0开始，为了统一，我们将其值加1
        this.number = page.getCurrentPage();
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setShowBefore(int showBefore) {
        this.showBefore = showBefore;
    }

    public void setHideInfo(boolean hideInfo) {
        this.hideInfo = hideInfo;
    }

    @Override
    protected int doStartTagInternal() throws IOException {
        pageContext.getOut().write(paginationCode());
        return SKIP_BODY;
    }

    public String paginationCode() {
        int startPage = determineStartPage(number);
        int endPage = determineEndPage(startPage, totalPages);

        Integer prev = (number > 1) ? (number - 1) : 0;
        Integer next = (number < totalPages) ? (number + 1) : number;
        StringBuilder sb = new StringBuilder();

        if (!hideInfo) {
            sb.append("<div class=\"span4\" style=\"margin-top:10px;\">");
            sb.append("<div class=\"dataTables_info\">");
            sb.append(resolveLabel("common.pagination.show"));
            if (0 == number) {
                sb.append("0-");
            }
            // 当显示第一页，且第一页无记录（查询无数据展示）时，计数从0开始，而不是从1开始，即显示为(0-0)，而不是(1-0)
            else if (1 == number && 0 == totalElements) {
                sb.append("0-");
            } else {
                sb.append(((number - 1) * size + 1) + "-");
            }
            sb.append((number * size) > totalElements ? totalElements : (number * size));
            sb.append(", ");
            sb.append(resolveLabel("common.pagination.total"));
            sb.append(totalElements);
            sb.append(resolveLabel("common.pagination.unit"));
            sb.append(DIV_STR);
            sb.append(DIV_STR);
        }

        sb.append(!hideInfo ? "<div class=\"span8\">" : "<div class=\"span12\">");
        sb.append("<div class=\"dataTables_paginate paging_bootstrap pagination\">");

        if (prev == 0) {
            sb.append("<ul><li class='prev disabled'><a href='#'>←" + resolveLabel("common.pagination.prev") + A_LI_STR);
        } else {
            sb.append("<ul><li><a href='" + buildHrefAttribute(prev) + "' >←" + resolveLabel("common.pagination.prev")
                    + A_LI_STR);
        }

        if (startPage != 1) {
            sb.append("<li><a href='" + buildHrefAttribute(1) + "' >1" + A_LI_STR);
            if (startPage != 2) {
                sb.append("<li><a href='#' >...</a></li>");
            }
        }

        for (int index = startPage; index <= endPage; index++) {
            String css;
            String href = buildHrefAttribute(index);
            if (index == number) {
                css = "active";
                href = "#";
            } else {
                css = "";
            }
            sb.append("<li class=\"" + css + "\"><a  href='" + href + "' >" + index + A_LI_STR);
        }

        if (endPage < totalPages) {
            if (endPage != (totalPages - 1)) {
                sb.append("<li><a href='#' >...</a></li>");
            }
            sb.append("<li><a  href='" + buildHrefAttribute(totalPages) + "' >" + totalPages + A_LI_STR);
        }

        if (next.equals(number)) {
            sb.append("<li class=\"next disabled\"><a href='#'>" + resolveLabel("common.pagination.next")
                    + "→</a></li>");
        } else {
            sb.append("<li class=\"next\"><a href='" + buildHrefAttribute(next) + "' >"
                    + resolveLabel("common.pagination.next") + "→</a></li>");
        }
        sb.append("</ul>");
        sb.append(DIV_STR);
        sb.append(DIV_STR);
        return sb.toString();
    }

    protected int determineStartPage(int pageNumber) {
        int startPage;
        if (pageNumber - showBefore >= 1) {
            startPage = pageNumber - showBefore;
        } else {
            startPage = 1;
        }
        return startPage;
    }

    protected int determineEndPage(int startPage, int totalPages) {
        int endPage;
        endPage = startPage + 5;
        if (endPage > totalPages) {
            endPage = totalPages;
        }
        return endPage;
    }

    protected String buildHrefAttribute(int number) {
        return "javascript:EnvbaseUtil.turn2Page(" + number + ");";
    }

    public String resolveLabel(String label) {
        MessageSource messageSource = getRequestContext().getMessageSource();
        return messageSource.getMessage(label, null, getRequestContext().getLocale());
    }
}