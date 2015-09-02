/**
 * Description: 给哪些用户发需求通知，我接收到的需求数据访问实现类
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
package com.env.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IDrmReqNoticeDao;
import com.env.dto.DrmReqNotice;

/**
 * 给哪些用户发需求通知，我接收到的需求数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Repository("drmReqNoticeDao")
public class DrmReqNoticeDao extends DefaultDaoImpl<DrmReqNotice> implements IDrmReqNoticeDao<DrmReqNotice> {
	
	public List<DrmReqNotice> queryByParams(Map params) {
		return this.query(getStatement(), params);
	}
}
