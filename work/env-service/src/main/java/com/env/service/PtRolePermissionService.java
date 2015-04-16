/**
 * Description: PtRolePermission业务实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-01-07 下午 13:52:25
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-01-07   caoyx   1.0         Initial
 */
package com.env.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.env.dao.api.Dao;
import com.env.service.impl.DefaultServiceImpl;

import com.env.dao.intf.IPtRolePermissionDao;
import com.env.service.intf.IPtRolePermissionService;
import com.env.dto.PtRolePermission;

/**
 * PtRolePermission业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
@Service("ptRolePermissionService")
public class PtRolePermissionService<T extends PtRolePermission> extends DefaultServiceImpl<T> implements IPtRolePermissionService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IPtRolePermissionDao ptRolePermissionDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) ptRolePermissionDao;
	}
}