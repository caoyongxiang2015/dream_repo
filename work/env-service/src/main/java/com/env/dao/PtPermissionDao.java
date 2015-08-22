/**
 * Description: PtPermission数据访问实现类
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
package com.env.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IPtPermissionDao;
import com.env.dto.PtPermission;

/**
 * PtPermission数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Repository("ptPermissionDao")
public class PtPermissionDao extends DefaultDaoImpl<PtPermission> implements IPtPermissionDao<PtPermission> {

	@Override
	public List<PtPermission> getByAppid(Integer appId) {
		Map<String,Integer> params = new HashMap<String,Integer>();
		params.put("appId", appId);
		return this.query(getStatement(), params);
	}
}
