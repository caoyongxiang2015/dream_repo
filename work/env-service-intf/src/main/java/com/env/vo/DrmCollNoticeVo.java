/**
 * Description: 用户提醒平台收录公司页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-09-12 下午 17:50:55
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-09-12   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmCollNotice;

/**
 * 用户提醒平台收录公司页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-09-12
 * @see
 * @since 1.0
 */
public class DrmCollNoticeVo{
	/**
	 * 用户提醒平台收录公司实体
	 */
	private DrmCollNotice entity;
	

	/**
	 * 设置用户提醒平台收录公司实体
	 * @param entity 用户提醒平台收录公司实体
	 */
	public void setEntity(DrmCollNotice entity) {
		this.entity = entity;
	}

	/**
	 * 获取用户提醒平台收录公司实体
	 * @return 用户提醒平台收录公司实体
	 */
	public DrmCollNotice getEntity() {
		return this.entity;
	}
}