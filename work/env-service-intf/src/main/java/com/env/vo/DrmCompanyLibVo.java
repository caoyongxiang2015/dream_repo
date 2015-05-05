/**
 * Description: DrmCompanyLib页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:01
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmCompanyLib;

/**
 * DrmCompanyLib页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public class DrmCompanyLibVo{
	/**
	 * DrmCompanyLib实体
	 */
	private DrmCompanyLib entity;
	

	/**
	 * 设置DrmCompanyLib实体
	 * @param entity DrmCompanyLib实体
	 */
	public void setEntity(DrmCompanyLib entity) {
		this.entity = entity;
	}

	/**
	 * 获取DrmCompanyLib实体
	 * @return DrmCompanyLib实体
	 */
	public DrmCompanyLib getEntity() {
		return this.entity;
	}
}