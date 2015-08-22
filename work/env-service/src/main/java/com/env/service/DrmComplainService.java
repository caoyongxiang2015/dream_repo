/**
 * Description: 投诉业务实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:48
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

import com.env.dao.intf.IDrmComplainDao;
import com.env.service.intf.IDrmComplainService;
import com.env.dto.DrmComplain;

/**
 * 投诉业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Service("drmComplainService")
public class DrmComplainService<T extends DrmComplain> extends DefaultServiceImpl<T> implements IDrmComplainService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmComplainDao<DrmComplain> drmComplainDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmComplainDao;
	}
}