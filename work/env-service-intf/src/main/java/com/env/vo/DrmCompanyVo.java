/**
 * Description: DrmCompany页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:00
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmCompany;

/**
 * DrmCompany页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public class DrmCompanyVo{
	/**
	 * DrmCompany实体
	 */
	private DrmCompany entity;
	

	/**
	 * 设置DrmCompany实体
	 * @param entity DrmCompany实体
	 */
	public void setEntity(DrmCompany entity) {
		this.entity = entity;
	}

	/**
	 * 获取DrmCompany实体
	 * @return DrmCompany实体
	 */
	public DrmCompany getEntity() {
		return this.entity;
	}
}