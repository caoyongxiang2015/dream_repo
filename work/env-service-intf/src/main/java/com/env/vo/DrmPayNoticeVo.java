/**
 * Description: 付款通知页面表单对象
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

import com.env.dto.DrmPayNotice;

/**
 * 付款通知页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmPayNoticeVo{
	/**
	 * 付款通知实体
	 */
	private DrmPayNotice entity;
	

	/**
	 * 设置付款通知实体
	 * @param entity 付款通知实体
	 */
	public void setEntity(DrmPayNotice entity) {
		this.entity = entity;
	}

	/**
	 * 获取付款通知实体
	 * @return 付款通知实体
	 */
	public DrmPayNotice getEntity() {
		return this.entity;
	}
}