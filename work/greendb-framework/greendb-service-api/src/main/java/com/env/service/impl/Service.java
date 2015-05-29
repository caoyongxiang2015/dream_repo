package com.env.service.impl;

/**  
 * Description: <类功能描述-必填> 公共接口，包括添加、修改、删除、通过id查询、分页查询、查询总数
 * Copyright:   Copyright (c)2014  
 * @version:    1.0  
 *  
 * Modification History:  
 * Date         Author      Version     Description  
 * ------------------------------------------------------------------  
 */

import java.util.List;

import com.env.core.domain.DomainObject;
import com.env.dao.api.QueryParams;

public interface Service<T extends DomainObject> {

    /**
     * {方法的功能/动作描述}
     * 
     * @param {引入参数名} {引入参数说明}
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public Integer save(T entity);
    
    /**
     * {新增或者修改}
     * 
     * @param {引入参数名} {引入参数说明}
     * @return {返回正数，新增成功，返回0修改成功，返回-1操作异常} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public Integer saveORupdate(T entity);
    
    /**
     * {方法的功能/动作描述}
     * 
     * @param {引入参数名} {引入参数说明}
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public void update(T entity);

    /**
     * {方法的功能/动作描述}
     * 
     * @param {引入参数名} {引入参数说明}
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public void delete(Integer id);

    /**
     * {方法的功能/动作描述}
     * 
     * @param {引入参数名} {引入参数说明}
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public void deleteByIds(Integer... ids);

    /**
     * {方法的功能/动作描述}
     * 
     * @param {引入参数名} {引入参数说明}
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public T getById(Integer id);

    /**
     * {方法的功能/动作描述}
     * 
     * @param {引入参数名} {引入参数说明}
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public List<T> queryByPage(QueryParams<?> queryParams);

    /**
     * {方法的功能/动作描述}
     * 
     * @param {引入参数名} {引入参数说明}
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public List<T> queryAll();

    /**
     * {方法的功能/动作描述}
     * 
     * @param {引入参数名} {引入参数说明}
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public List<T> queryAll(QueryParams<?> queryParams);

    /**
     * {方法的功能/动作描述}
     * 
     * @param {引入参数名} {引入参数说明}
     * @return {返回参数名} {返回参数说明}
     * @exception {说明在某情况下,将发生什么异常}
     */
    public int getTotalCount(Object params);
}
