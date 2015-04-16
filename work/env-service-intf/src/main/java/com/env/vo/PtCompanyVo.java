/**
 * Description: PtCompany页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-01-07 下午 14:18:51
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-01-07   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.PtCompany;

/**
 * PtCompany页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
public class PtCompanyVo{
	/**
	 * PtCompany实体
	 */
	private PtCompany entity;
	

	/**
	 * 设置PtCompany实体
	 * @param entity PtCompany实体
	 */
	public void setEntity(PtCompany entity) {
		this.entity = entity;
	}

	/**
	 * 获取PtCompany实体
	 * @return PtCompany实体
	 */
	public PtCompany getEntity() {
		return this.entity;
	}
}