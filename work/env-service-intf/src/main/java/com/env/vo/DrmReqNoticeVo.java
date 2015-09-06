/**
 * Description: 给哪些用户发需求通知，我接收到的需求页面表单对象
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

import com.env.dto.DrmReqNotice;

/**
 * 给哪些用户发需求通知，我接收到的需求页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmReqNoticeVo{
	/**
	 * 给哪些用户发需求通知，我接收到的需求实体
	 */
	private DrmReqNotice entity;
	

	/**
	 * 设置给哪些用户发需求通知，我接收到的需求实体
	 * @param entity 给哪些用户发需求通知，我接收到的需求实体
	 */
	public void setEntity(DrmReqNotice entity) {
		this.entity = entity;
	}

	/**
	 * 获取给哪些用户发需求通知，我接收到的需求实体
	 * @return 给哪些用户发需求通知，我接收到的需求实体
	 */
	public DrmReqNotice getEntity() {
		return this.entity;
	}
}