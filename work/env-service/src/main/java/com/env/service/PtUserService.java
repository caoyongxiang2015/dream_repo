/**
 * Description: PtUser业务实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:53
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
import com.env.dao.intf.IPtUserDao;
import com.env.dto.PtUser;
import com.env.service.impl.DefaultServiceImpl;
import com.env.service.intf.IPtUserService;

/**
 * PtUser业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
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

	@Override
	public boolean isExistLoginid(String loginId) {
		boolean exist = ptUserDao.isExistLoginid(loginId);
		return exist;
	}

	@Override
	public PtUser loginUser(String loginId, String password) {
		PtUser user = ptUserDao.loginUser(loginId, password);
		return user;
	}


	@Override
	public PtUser getByLoginid(String loginId) {
		return ptUserDao.getByLoginid(loginId);
	}

	@Override
	public boolean userRegister(PtUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}

}