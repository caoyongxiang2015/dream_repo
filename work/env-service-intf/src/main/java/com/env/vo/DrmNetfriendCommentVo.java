/**
 * Description: DrmNetfriendComment页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-11-09 下午 22:58:36
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-11-09   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmNetfriendComment;

/**
 * DrmNetfriendComment页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-11-09
 * @see
 * @since 1.0
 */
public class DrmNetfriendCommentVo{
	/**
	 * DrmNetfriendComment实体
	 */
	private DrmNetfriendComment entity;
	

	/**
	 * 设置DrmNetfriendComment实体
	 * @param entity DrmNetfriendComment实体
	 */
	public void setEntity(DrmNetfriendComment entity) {
		this.entity = entity;
	}

	/**
	 * 获取DrmNetfriendComment实体
	 * @return DrmNetfriendComment实体
	 */
	public DrmNetfriendComment getEntity() {
		return this.entity;
	}
}