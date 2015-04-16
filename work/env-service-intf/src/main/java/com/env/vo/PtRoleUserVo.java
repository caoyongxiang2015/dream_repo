/**
 * Description: PtRoleUser页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-01-07 下午 14:18:52
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-01-07   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.PtRoleUser;

/**
 * PtRoleUser页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
public class PtRoleUserVo{
	/**
	 * PtRoleUser实体
	 */
	private PtRoleUser entity;
	

	/**
	 * 设置PtRoleUser实体
	 * @param entity PtRoleUser实体
	 */
	public void setEntity(PtRoleUser entity) {
		this.entity = entity;
	}

	/**
	 * 获取PtRoleUser实体
	 * @return PtRoleUser实体
	 */
	public PtRoleUser getEntity() {
		return this.entity;
	}
}