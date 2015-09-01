/**
 * Description: PtUser数据访问实现类
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
package com.env.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IPtUserDao;
import com.env.dto.PtUser;

/**
 * PtUser数据访问实现类<br>
 * 
 * test
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Repository("ptUserDao")
public class PtUserDao extends DefaultDaoImpl<PtUser> implements IPtUserDao<PtUser> {

	@Override
	public boolean isExistLoginid(String loginId) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("loginId", loginId);
		List<PtUser> users = this.query(getStatement(), params);
		return (users!=null && users.size()>0);
	}


	@Override
	public PtUser loginUser(String loginId, String password) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("loginId", loginId);
		params.put("pwd", password);
		PtUser user = this.getEntity(getStatement(), params);
		return user;
	}

	@Override
	public PtUser getByLoginid(String loginId) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("loginId", loginId);
		PtUser user = this.getEntity(getStatement(), params);
		return user;
	}


	@Override
	public List<PtUser> queryAllByParams(PtUser user) {
		Map params = new HashMap();
		params.put("entity", user);
		return this.query(getStatement(), params);
	}

}
