package com.env.service.impl;

import java.util.List;

import com.env.core.domain.DomainObject;
import com.env.dao.api.Dao;
import com.env.dao.api.QueryParams;

/**
 * 默认的Service实现
 * 
 * 
 */
public abstract class DefaultServiceImpl<T extends DomainObject> implements
        Service<T> {

    public Integer save(T entity) {
        return getDao().save(entity);
    }

    public void update(T entity) {
        getDao().update(entity);
    }

    public void delete(Integer id) {
        getDao().delete(id);
    }

    public void deleteByIds(Integer... ids) {
        getDao().deleteByIds(ids);
    }

    public T getById(Integer id) {
        return getDao().getById(id);
    }

    public List<T> queryByPage(QueryParams<?> queryParams) {
        return getDao().queryByPage(queryParams);
    }

    public List<T> queryAll() {
        return getDao().queryAll();
    }

    public List<T> queryAll(QueryParams<?> queryParams) {
        return getDao().queryAll(queryParams);
    }

    public int getTotalCount(Object params) {
        return getDao().getTotalCount(params);
    }

    /**
     * 获取DAO实例<br>
     * 由子类通过自动注入或其他方式获取后，实现该方法返回具体实例
     * 
     * @return 获取DAO实例
     */
    protected abstract Dao<T> getDao();
}
