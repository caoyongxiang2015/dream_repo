/**
 * Description: PtRole页面表单对象
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

import com.env.dto.PtRole;

/**
 * PtRole页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
public class PtRoleVo{
	/**
	 * PtRole实体
	 */
	private PtRole entity;
	

	/**
	 * 设置PtRole实体
	 * @param entity PtRole实体
	 */
	public void setEntity(PtRole entity) {
		this.entity = entity;
	}

	/**
	 * 获取PtRole实体
	 * @return PtRole实体
	 */
	public PtRole getEntity() {
		return this.entity;
	}
}