/**
 * Description: 用户注册的公司信息页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:46
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmCompany;

/**
 * 用户注册的公司信息页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmCompanyVo{
	/**
	 * 用户注册的公司信息实体
	 */
	private DrmCompany entity;
	private DrmCompany entity2;
	

	public DrmCompany getEntity2() {
		return entity2;
	}

	public void setEntity2(DrmCompany entity2) {
		this.entity2 = entity2;
	}

	/**
	 * 设置用户注册的公司信息实体
	 * @param entity 用户注册的公司信息实体
	 */
	public void setEntity(DrmCompany entity) {
		this.entity = entity;
	}

	/**
	 * 获取用户注册的公司信息实体
	 * @return 用户注册的公司信息实体
	 */
	public DrmCompany getEntity() {
		return this.entity;
	}
}