/**
 * Description: 用户注册的部门信息页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:48
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmDept;

/**
 * 用户注册的部门信息页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmDeptVo{
	/**
	 * 用户注册的部门信息实体
	 */
	private DrmDept entity;
	

	/**
	 * 设置用户注册的部门信息实体
	 * @param entity 用户注册的部门信息实体
	 */
	public void setEntity(DrmDept entity) {
		this.entity = entity;
	}

	/**
	 * 获取用户注册的部门信息实体
	 * @return 用户注册的部门信息实体
	 */
	public DrmDept getEntity() {
		return this.entity;
	}
}