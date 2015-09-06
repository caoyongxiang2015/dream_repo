/**
 * Description: 意见反馈页面表单对象
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

import com.env.dto.PtFeedback;

/**
 * 意见反馈页面表单对象<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public class PtFeedbackVo{
	/**
	 * 意见反馈实体
	 */
	private PtFeedback entity;
	

	/**
	 * 设置意见反馈实体
	 * @param entity 意见反馈实体
	 */
	public void setEntity(PtFeedback entity) {
		this.entity = entity;
	}

	/**
	 * 获取意见反馈实体
	 * @return 意见反馈实体
	 */
	public PtFeedback getEntity() {
		return this.entity;
	}
}