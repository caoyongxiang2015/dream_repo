/**
 * Description: 记录用户对公司的搜索次数页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:51
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmSearchRecord;

/**
 * 记录用户对公司的搜索次数页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmSearchRecordVo{
	/**
	 * 记录用户对公司的搜索次数实体
	 */
	private DrmSearchRecord entity;
	

	/**
	 * 设置记录用户对公司的搜索次数实体
	 * @param entity 记录用户对公司的搜索次数实体
	 */
	public void setEntity(DrmSearchRecord entity) {
		this.entity = entity;
	}

	/**
	 * 获取记录用户对公司的搜索次数实体
	 * @return 记录用户对公司的搜索次数实体
	 */
	public DrmSearchRecord getEntity() {
		return this.entity;
	}
}