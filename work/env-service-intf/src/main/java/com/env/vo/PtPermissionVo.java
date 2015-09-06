/**
 * Description: PtPermission页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:51
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.PtPermission;

/**
 * PtPermission页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class PtPermissionVo{
	/**
	 * PtPermission实体
	 */
	private PtPermission entity;
	

	/**
	 * 设置PtPermission实体
	 * @param entity PtPermission实体
	 */
	public void setEntity(PtPermission entity) {
		this.entity = entity;
	}

	/**
	 * 获取PtPermission实体
	 * @return PtPermission实体
	 */
	public PtPermission getEntity() {
		return this.entity;
	}
}