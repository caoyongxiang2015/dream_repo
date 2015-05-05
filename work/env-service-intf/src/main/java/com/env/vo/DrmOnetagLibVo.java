/**
 * Description: DrmOnetagLib页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:02
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmOnetagLib;

/**
 * DrmOnetagLib页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public class DrmOnetagLibVo{
	/**
	 * DrmOnetagLib实体
	 */
	private DrmOnetagLib entity;
	

	/**
	 * 设置DrmOnetagLib实体
	 * @param entity DrmOnetagLib实体
	 */
	public void setEntity(DrmOnetagLib entity) {
		this.entity = entity;
	}

	/**
	 * 获取DrmOnetagLib实体
	 * @return DrmOnetagLib实体
	 */
	public DrmOnetagLib getEntity() {
		return this.entity;
	}
}