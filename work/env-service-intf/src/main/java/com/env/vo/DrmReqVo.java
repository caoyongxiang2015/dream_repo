/**
 * Description: 需求页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:50
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmReq;

/**
 * 需求页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmReqVo{
	/**
	 * 需求实体
	 */
	private DrmReq entity;
	

	/**
	 * 设置需求实体
	 * @param entity 需求实体
	 */
	public void setEntity(DrmReq entity) {
		this.entity = entity;
	}

	/**
	 * 获取需求实体
	 * @return 需求实体
	 */
	public DrmReq getEntity() {
		return this.entity;
	}
}