package com.env.dao.api;

/**
 * 
 */

import java.util.List;

/**
 * 公共DAO接口<br>
 * 公共接口，包括添加、修改、删除、通过id查询、分页查询、查询总数
 * 
 */
public interface Dao<T> {

    /**
     * 保存<br>
     * 
     * @param entity
     *            实体
     * @return
     * @see
     */
    Integer save(T entity);

    /**
     * 修改 <br>
     * 
     * @param entity
     * @see
     */
    void update(T entity);

    /**
     * 删除<br>
     * 
     * @param id
     * @see
     */
    void delete(Integer id);

    /**
     * 批量删除<br>
     * 
     * @param ids
     * @see
     */
    void deleteByIds(Integer... ids);

    /**
     * 
     * 通过id查询 <br>
     * 
     * @param id
     * @return
     * @see
     */
    T getById(Integer id);

    /**
     * 
     * 分页查询 <br>
     * 
     * @param queryParams
     * @return
     * @see
     */
    List<T> queryByPage(QueryParams<?> queryParams);

    /**
     * 
     * 获取所有数据 <br>
     * 
     * @return
     * @see
     */
    List<T> queryAll();

    /**
     * 
     * 获取符合条件的所有数据 <br>
     * 
     * @return
     * @see
     */
    List<T> queryAll(QueryParams<?> queryParams);

    /**
     * 
     * 获取总数 <br>
     * 
     * @param params
     * @return
     * @see
     */
    int getTotalCount(Object params);
}
