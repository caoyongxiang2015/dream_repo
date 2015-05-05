/**
 * Description: DrmOnetag页面表单对象
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

import com.env.dto.DrmOnetag;

/**
 * DrmOnetag页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public class DrmOnetagVo{
	/**
	 * DrmOnetag实体
	 */
	private DrmOnetag entity;
	

	/**
	 * 设置DrmOnetag实体
	 * @param entity DrmOnetag实体
	 */
	public void setEntity(DrmOnetag entity) {
		this.entity = entity;
	}

	/**
	 * 获取DrmOnetag实体
	 * @return DrmOnetag实体
	 */
	public DrmOnetag getEntity() {
		return this.entity;
	}
}