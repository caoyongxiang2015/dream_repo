/**
 * Description: 用户发布需求；搜索公司 都把公司记录下来页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-09-01 下午 21:01:45
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-09-01   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmSearchCompany;

/**
 * 用户发布需求；搜索公司 都把公司记录下来页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-09-01
 * @see
 * @since 1.0
 */
public class DrmSearchCompanyVo{
	/**
	 * 用户发布需求；搜索公司 都把公司记录下来实体
	 */
	private DrmSearchCompany entity;
	

	/**
	 * 设置用户发布需求；搜索公司 都把公司记录下来实体
	 * @param entity 用户发布需求；搜索公司 都把公司记录下来实体
	 */
	public void setEntity(DrmSearchCompany entity) {
		this.entity = entity;
	}

	/**
	 * 获取用户发布需求；搜索公司 都把公司记录下来实体
	 * @return 用户发布需求；搜索公司 都把公司记录下来实体
	 */
	public DrmSearchCompany getEntity() {
		return this.entity;
	}
}