/**
 * Description: PtRole数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-01-07 下午 13:35:29
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

import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IPtRoleDao;
import com.env.dto.PtRole;

/**
 * PtRole数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
@Repository("ptRoleDao")
public class PtRoleDao extends DefaultDaoImpl<PtRole> implements IPtRoleDao<PtRole> {
	@Override
	public List<PtRole> getByUserid(Integer userId) {
		// 
		Map<String,Integer> params = new HashMap<String, Integer>();
		params.put("userId", userId);
		List<PtRole> roles = this.query(getStatement(), params);
		return roles;
	}
}
