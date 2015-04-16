package com.env.dao.api;

/**  
 * Description: <类功能描述-必填> 
 * @version:    1.0  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


/**
 * 查询参数基类
 * 
 * @param <T>
 *            结果对象类型，一般为领域对象
 */
public class QueryParams<T> {
    /**
     * 操作枚举类
     * 
     */
    enum Operation {
        /**
         * 等值比较
         */
        EQ("="),
        /**
         * 不等值比较
         */
        NOTEQ("!="),
        /**
         * 大于比较
         */
        GT(">"),
        /**
         * 小于比较
         */
        LT("<"),
        /**
         * 大于等于比较
         */
        GTE(">="),
        /**
         * 小于等于比较
         */
        LTE("<="),
        /**
         * 模糊匹配
         */
        LIKE("like"),
        /**
         * 反向模糊匹配
         */
        NOTLIKE("not like");
        /**
         * 操作符
         */
        private String operator;

        /**
         * @return the operator
         */
        public String getOperator() {
            return operator;
        }

        /**
         * 枚举构造器
         * 
         * @param operator
         *            操作符
         */
        private Operation(String operator) {
            this.operator = operator;
        }

        /**
         * 值转换<br>
         * 根据操作符的不同构造不同的值形式
         * 
         * @param value
         *            原始值
         * @return 改造值
         */
        public Object convertValue(Object value) {
            switch (this) {
            // 当使用like或not like时，需要在value两侧增加%，以达到模糊查询的目的
            case LIKE:
            case NOTLIKE:
                return "%" + value + "%";
            default:
                return value;
            }
        }
    }

    /**
     * added by ixr_wang
     */
    private T entity;

    /**
     * 原始查询条件
     */
    private Map<String, Object> searchParams;

    /**
     * 查询过滤
     */
    private Map<String, SearchFilter> searchFilters = new HashMap<String, SearchFilter>();

    /**
     * 排序列 added by andy_luo
     */
    private String orderColumn;

    /**
     * 排序方式。只允许两个值。desc和asc
     */
    private String orderMode = "desc";

    /**
     * 可以通过该参数直接指定查询多少条。
     */
    private int limit;

    /**
     * 分页控制器
     */
    private Page paging = new Page();

    /**
     * 无参构造器
     */
    public QueryParams() {
    }

    /**
     * 带查询条件构造器
     * 
     * @param searchParams
     *            查询条件
     */
    public QueryParams(Map<String, Object> searchParams) {
        setSearchParams(searchParams);
    }

    /**
     * @return the limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * @return the orderColumn
     */
    public String getOrderColumn() {
        return orderColumn;
    }

    /**
     * @return the orderMode
     */
    public String getOrderMode() {
        return orderMode;
    }

    /**
     * @return the paging
     */
    public Page getPaging() {
        return paging;
    }

    /**
     * @param limit
     *            the limit to set
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * @param orderColumn
     *            the orderMode to set
     */
    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    /**
     * @param orderMode
     *            the orderMode to set
     */
    public void setOrderMode(String orderMode) {
        this.orderMode = orderMode;
    }

    /**
     * @param paging
     *            the paging to set
     */
    public void setPaging(Page paging) {
        this.paging = paging;
    }

    /**
     * @return the searchParams
     */
    public Map<String, Object> getSearchParams() {
        return searchParams;
    }

    /**
     * @param searchParams
     *            the searchParams to set
     */
    public void setSearchParams(Map<String, Object> searchParams) {
        this.searchParams = searchParams;
        buildSearchFilters(searchParams);
    }

    /**
     * 构建过滤条件
     * 
     * @param searchParams
     *            查询条件
     */
    private void buildSearchFilters(Map<String, Object> searchParams) {
        Map<String, Object> tmpSearchParams = new HashMap<String, Object>();
        // Trim空格
        for (String key : searchParams.keySet()) {
            Object value = searchParams.get(key);
            if (null != value && value instanceof String) {
                value = value.toString().trim();
            }
            tmpSearchParams.put(key, value);
        }
        searchParams.clear();
        searchParams.putAll(tmpSearchParams);
        for (Map.Entry<String, Object> entry : searchParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            // 如果value为空，不作为筛选条件
            if (value == null) {
                continue;
            }
            if (value instanceof String && StringUtils.isBlank((String) value)) {
                continue;
            }
            String[] names = StringUtils.split(key, "_");
            int namesLen = names.length;
            // 这里预留后两部分，用于类型转换
            if (2 > namesLen && 3 < namesLen) {
                throw new IllegalArgumentException(key + " is not a valid search filter name");
            }
            String filedName = names[1];
            Operation operation = Operation.valueOf(names[0]);
//            Operation operation = Operation.valueOf(names[1]);// names: search,EQ,name
            if (3 <= namesLen) {
                String dateStyle = names[2];
                try {
                    value = convert(dateStyle, value);
                } catch (ParseException e) {
                    throw new IllegalArgumentException(key + " is not a date type");
                }
            }

            this.searchFilters.put(filedName, new SearchFilter(operation.operator, operation.convertValue(value)));
        }
    }

    /**
     * 取值转换
     * 
     * @param style
     *            类型
     * @param value
     *            原始值
     * @return 转换值
     * @throws ParseException
     *             解析异常
     */
    private Object convert(String style, Object value) throws ParseException {
        return new SimpleDateFormat(style).parse((String) value);
    }

    /**
     * @return the searchFilters
     */
    public Map<String, SearchFilter> getSearchFilters() {
        return searchFilters;
    }

    /**
     * @return the entity
     */
    public T getEntity() {
        return entity;
    }

    /**
     * @param entity
     *            the entity to set
     */
    public void setEntity(T entity) {
        this.entity = entity;
    }
}
