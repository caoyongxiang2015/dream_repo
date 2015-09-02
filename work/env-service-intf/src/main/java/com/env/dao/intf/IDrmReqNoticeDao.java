/**
 * Description: 给哪些用户发需求通知，我接收到的需求数据访问接口
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:50
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.dao.intf;

import java.util.List;
import java.util.Map;

import com.env.dao.api.Dao;
import com.env.dto.DrmReqNotice;

/**
 * 给哪些用户发需求通知，我接收到的需求数据访问接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IDrmReqNoticeDao<T extends DrmReqNotice> extends Dao<T> {

	/**
	 * 根据条件查询
	 * @param params
	 * @return
	 */
	public List<DrmReqNotice> queryByParams(Map params);
}

