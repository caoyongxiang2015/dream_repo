/**
 * Description: PtUser页面表单对象
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

import com.env.dto.PtUser;

/**
 * PtUser页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class PtUserVo{
	/**
	 * PtUser实体
	 */
	private PtUser entity;
	

	/**
	 * 设置PtUser实体
	 * @param entity PtUser实体
	 */
	public void setEntity(PtUser entity) {
		this.entity = entity;
	}

	/**
	 * 获取PtUser实体
	 * @return PtUser实体
	 */
	public PtUser getEntity() {
		return this.entity;
	}
}