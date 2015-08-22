/**
 * Description: url访问日志页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:53
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.PtVisitLog;

/**
 * url访问日志页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class PtVisitLogVo{
	/**
	 * url访问日志实体
	 */
	private PtVisitLog entity;
	

	/**
	 * 设置url访问日志实体
	 * @param entity url访问日志实体
	 */
	public void setEntity(PtVisitLog entity) {
		this.entity = entity;
	}

	/**
	 * 获取url访问日志实体
	 * @return url访问日志实体
	 */
	public PtVisitLog getEntity() {
		return this.entity;
	}
}