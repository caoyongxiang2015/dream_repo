/**
 * Description: DrmDeptLib业务实现类
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
package com.env.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.env.dao.api.Dao;
import com.env.service.impl.DefaultServiceImpl;

import com.env.dao.intf.IDrmDeptLibDao;
import com.env.service.intf.IDrmDeptLibService;
import com.env.dto.DrmDeptLib;

/**
 * DrmDeptLib业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Service("drmDeptLibService")
public class DrmDeptLibService<T extends DrmDeptLib> extends DefaultServiceImpl<T> implements IDrmDeptLibService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmDeptLibDao<DrmDeptLib> drmDeptLibDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmDeptLibDao;
	}
}