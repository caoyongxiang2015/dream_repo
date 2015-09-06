/**
 * Description: PtRoleUser页面表单对象
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

import com.env.dto.PtRoleUser;

/**
 * PtRoleUser页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
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