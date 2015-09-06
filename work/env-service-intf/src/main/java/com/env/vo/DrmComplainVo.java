/**
 * Description: 投诉页面表单对象
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

import com.env.dto.DrmComplain;

/**
 * 投诉页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmComplainVo{
	/**
	 * 投诉实体
	 */
	private DrmComplain entity;
	

	/**
	 * 设置投诉实体
	 * @param entity 投诉实体
	 */
	public void setEntity(DrmComplain entity) {
		this.entity = entity;
	}

	/**
	 * 获取投诉实体
	 * @return 投诉实体
	 */
	public DrmComplain getEntity() {
		return this.entity;
	}
}