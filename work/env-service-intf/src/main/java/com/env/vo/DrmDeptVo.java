/**
 * Description: DrmDept页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:01
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmDept;

/**
 * DrmDept页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public class DrmDeptVo{
	/**
	 * DrmDept实体
	 */
	private DrmDept entity;
	

	/**
	 * 设置DrmDept实体
	 * @param entity DrmDept实体
	 */
	public void setEntity(DrmDept entity) {
		this.entity = entity;
	}

	/**
	 * 获取DrmDept实体
	 * @return DrmDept实体
	 */
	public DrmDept getEntity() {
		return this.entity;
	}
}