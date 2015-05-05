/**
 * Description: DrmDeptLib页面表单对象
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

import com.env.dto.DrmDeptLib;

/**
 * DrmDeptLib页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public class DrmDeptLibVo{
	/**
	 * DrmDeptLib实体
	 */
	private DrmDeptLib entity;
	

	/**
	 * 设置DrmDeptLib实体
	 * @param entity DrmDeptLib实体
	 */
	public void setEntity(DrmDeptLib entity) {
		this.entity = entity;
	}

	/**
	 * 获取DrmDeptLib实体
	 * @return DrmDeptLib实体
	 */
	public DrmDeptLib getEntity() {
		return this.entity;
	}
}