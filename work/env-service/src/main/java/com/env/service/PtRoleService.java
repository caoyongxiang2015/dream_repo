/**
 * Description: PtRole业务实现类
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
package com.env.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.env.dao.api.Dao;
import com.env.dao.intf.IPtRoleDao;
import com.env.dto.PtRole;
import com.env.service.impl.DefaultServiceImpl;
import com.env.service.intf.IPtRoleService;

/**
 * PtRole业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Service("ptRoleService")
public class PtRoleService<T extends PtRole> extends DefaultServiceImpl<T> implements IPtRoleService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IPtRoleDao<PtRole> ptRoleDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) ptRoleDao;
	}
	@Override
	public List<PtRole> getByUserid(Integer userId) {
		return ptRoleDao.getByUserid(userId);
	}
}