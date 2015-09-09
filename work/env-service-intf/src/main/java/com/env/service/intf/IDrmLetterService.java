/**
 * Description: DrmLetter业务接口
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
package com.env.service.intf;

import java.util.List;
import java.util.Map;

import com.env.service.impl.Service;
import com.env.dto.DrmLetter;

/**
 * DrmLetter业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IDrmLetterService<T extends DrmLetter> extends Service<T> {
	public List<DrmLetter> queryLetter(Integer curUserid);
	/**
	 * 我与对方的私信往来列表
	 * @param myUserId
	 * @param yourUserId
	 * @return
	 */
	public List<DrmLetter> letterDetail(Integer myUserId,Integer yourUserId);
}