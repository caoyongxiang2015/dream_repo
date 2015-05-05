/**
 * Description: DrmTwotag页面表单对象
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

import com.env.dto.DrmTwotag;

/**
 * DrmTwotag页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public class DrmTwotagVo{
	/**
	 * DrmTwotag实体
	 */
	private DrmTwotag entity;
	

	/**
	 * 设置DrmTwotag实体
	 * @param entity DrmTwotag实体
	 */
	public void setEntity(DrmTwotag entity) {
		this.entity = entity;
	}

	/**
	 * 获取DrmTwotag实体
	 * @return DrmTwotag实体
	 */
	public DrmTwotag getEntity() {
		return this.entity;
	}
}