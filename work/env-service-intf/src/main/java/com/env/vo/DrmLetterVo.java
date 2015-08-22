/**
 * Description: DrmLetter页面表单对象
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:49
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.vo;

import com.env.dto.DrmLetter;

/**
 * DrmLetter页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class DrmLetterVo{
	/**
	 * DrmLetter实体
	 */
	private DrmLetter entity;
	

	/**
	 * 设置DrmLetter实体
	 * @param entity DrmLetter实体
	 */
	public void setEntity(DrmLetter entity) {
		this.entity = entity;
	}

	/**
	 * 获取DrmLetter实体
	 * @return DrmLetter实体
	 */
	public DrmLetter getEntity() {
		return this.entity;
	}
}