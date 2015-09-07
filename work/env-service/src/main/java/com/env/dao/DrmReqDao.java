/**
 * Description: 需求数据访问实现类
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
import com.env.dao.intf.IDrmReqDao;
import com.env.dto.DrmReq;

/**
 * 需求数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Repository("drmReqDao")
public class DrmReqDao extends DefaultDaoImpl<DrmReq> implements IDrmReqDao<DrmReq> {

	@Override
	public List<DrmReq> queryByParams(Map params) {
		return this.query(getStatement(), params);
	}
}
