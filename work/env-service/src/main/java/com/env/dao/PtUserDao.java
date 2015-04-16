/**
 * Description: PtUser数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-01-07 下午 13:35:30
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-01-07   caoyx   1.0         Initial
 */
package com.env.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.env.core.domain.DomainObject;
import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IPtUserDao;
import com.env.dto.PtUser;

/**
 * PtUser数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
@Repository("ptUserDao")
public class PtUserDao extends DefaultDaoImpl<PtUser> implements IPtUserDao<PtUser> {

    //TODO 测试
	public boolean cfg_field_category(List<PtUser> us){
		for(PtUser u : us){
			Integer id = this.save( u);
			System.out.println(">>>>>"+ id);
		}
		return false;
	}

	public boolean isExistLoginid(String loginId) {
		Map<String,String> params = new HashMap<String,String>();
		params.put("loginId", loginId);
		List<PtUser> users = this.query(getStatement(), params);
		return (users!=null && users.size()>0);
	}


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
}
