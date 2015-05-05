/**
 * Description: DrmTwotagLib页面表单对象
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

import com.env.dto.DrmTwotagLib;

/**
 * DrmTwotagLib页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public class DrmTwotagLibVo{
	/**
	 * DrmTwotagLib实体
	 */
	private DrmTwotagLib entity;
	

	/**
	 * 设置DrmTwotagLib实体
	 * @param entity DrmTwotagLib实体
	 */
	public void setEntity(DrmTwotagLib entity) {
		this.entity = entity;
	}

	/**
	 * 获取DrmTwotagLib实体
	 * @return DrmTwotagLib实体
	 */
	public DrmTwotagLib getEntity() {
		return this.entity;
	}
}