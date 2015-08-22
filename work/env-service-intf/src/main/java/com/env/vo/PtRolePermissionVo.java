/**
 * Description: PtRolePermission页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:52
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.PtRolePermission;

/**
 * PtRolePermission页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class PtRolePermissionVo{
	/**
	 * PtRolePermission实体
	 */
	private PtRolePermission entity;
	

	/**
	 * 设置PtRolePermission实体
	 * @param entity PtRolePermission实体
	 */
	public void setEntity(PtRolePermission entity) {
		this.entity = entity;
	}

	/**
	 * 获取PtRolePermission实体
	 * @return PtRolePermission实体
	 */
	public PtRolePermission getEntity() {
		return this.entity;
	}
}