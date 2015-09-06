/**
 * Description: 公司库，搜索使用页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:47
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmCompanyLib;

/**
 * 公司库，搜索使用页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmCompanyLibVo{
	/**
	 * 公司库，搜索使用实体
	 */
	private DrmCompanyLib entity;
	

	/**
	 * 设置公司库，搜索使用实体
	 * @param entity 公司库，搜索使用实体
	 */
	public void setEntity(DrmCompanyLib entity) {
		this.entity = entity;
	}

	/**
	 * 获取公司库，搜索使用实体
	 * @return 公司库，搜索使用实体
	 */
	public DrmCompanyLib getEntity() {
		return this.entity;
	}
}