/**
 * Description: PtRoleUser业务实现类
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

import com.env.dao.intf.IPtRoleUserDao;
import com.env.service.intf.IPtRoleUserService;
import com.env.dto.PtRoleUser;

/**
 * PtRoleUser业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
@Service("ptRoleUserService")
public class PtRoleUserService<T extends PtRoleUser> extends DefaultServiceImpl<T> implements IPtRoleUserService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IPtRoleUserDao ptRoleUserDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) ptRoleUserDao;
	}
}