/**
 * Description: PtUser业务实现类
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

import com.env.dao.intf.IPtUserDao;
import com.env.service.intf.IPtUserService;
import com.env.dto.PtUser;

/**
 * PtUser业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
@Service("ptUserService")
public class PtUserService<T extends PtUser> extends DefaultServiceImpl<T> implements IPtUserService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IPtUserDao<PtUser> ptUserDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) ptUserDao;
	}

	public boolean isExistLoginid(String loginId) {
		boolean exist = ptUserDao.isExistLoginid(loginId);
		return exist;
	}

	public PtUser loginUser(String loginId, String password) {
		PtUser user = ptUserDao.loginUser(loginId, password);
		return user;
	}


	@Override
	public PtUser getByLoginid(String loginId) {
		return ptUserDao.getByLoginid(loginId);
	}

}