package com.env.dao.impl;

/** 
 * 
 */

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.env.core.domain.DomainObject;
import com.env.dao.api.Dao;
import com.env.dao.api.QueryParams;

/**
 * 默认dao实现<br>
 * 
 * @author caoyongxiang
 * 
 */
public class DefaultDaoImpl<T extends DomainObject> extends DaoImpl<T>
        implements Dao<T> {

    /**
     * 获取带命名空间的函数名 <br>
     * 
     * @param clazz
     * @return 返回类型为 ClassName.methodName
     * @see
     */
    public String getStatement(Class<?> clazz) {
        StackTraceElement[] stacks = new Exception().getStackTrace();
        return getStatement(clazz, stacks[1].getMethodName());
    }

    /**
     * 获取带命名空间的函数名<br>
     * 
     * @param clazz
     * @param methodName
     * @return 返回类型为 ClassName.methodName
     * @see
     */
    public String getStatement(Class<?> clazz, String methodName) {
        return clazz.getName() + "." + methodName;
    }

    /**
     * 根据T类型来算出带命名空间的函数名<br>
     * 
     * 
     * @return 返回类型为 ClassName.methodName
     * @see
     */
    public String getStatement() {
        StackTraceElement[] stacks = new Exception().getStackTrace();
        return getStatement(stacks[1].getMethodName());
    }

    /**
     * 根据T类型来算出带命名空间的函数名<br>
     * 
     * 
     * @param methodName
     *            方法名
     * @return 返回类型为 ClassName.methodName
     * @see
     */
    @SuppressWarnings("unchecked")
    public String getStatement(String methodName) {
        ParameterizedType type = ((ParameterizedType) getClass()
                .getGenericSuperclass());
        Class<T> entityClass = (Class<T>) (type.getActualTypeArguments()[0]);
        return getStatement(entityClass, methodName);
    }

    public void delete(Integer id) {
        delete(getStatement(), id);
    }

    public void deleteByIds(Integer... ids) {
        deleteByIds(getStatement(), ids);
    }

    public T getById(Integer id) {
        return this.getEntity(getStatement(), id);
    }

    public int getTotalCount(Object params) {
        return uniqueIntResult(getStatement("queryByPage")
                + COUNT_STATEMENT_SUFFIX, params);
    }

    public List<T> queryByPage(QueryParams<?> queryParams) {
        return this.queryByQueryParams(getStatement(), queryParams);
    }

    public Integer save(T entity) {
        this.save(getStatement(), entity);
        return entity.getId();
    }

    public void update(T entity) {
        this.update(getStatement(), entity);
    }

    public List<T> queryAll() {
        return this.query(getStatement());
    }

    public List<T> queryAll(QueryParams<?> queryParams) {
        return this.query(getStatement(), queryParams);
    }
}
