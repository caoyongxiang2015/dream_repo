/**
 * Description: 需求业务实现类
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
package com.env.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.env.dao.api.Dao;
import com.env.service.impl.DefaultServiceImpl;

import com.env.dao.intf.IDrmReqDao;
import com.env.service.intf.IDrmReqService;
import com.env.dto.DrmReq;

/**
 * 需求业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Service("drmReqService")
public class DrmReqService<T extends DrmReq> extends DefaultServiceImpl<T> implements IDrmReqService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmReqDao<DrmReq> drmReqDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmReqDao;
	}
}