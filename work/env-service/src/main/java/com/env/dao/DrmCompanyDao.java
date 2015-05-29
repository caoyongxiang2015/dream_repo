/**
 * Description: DrmCompany数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:00
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IDrmCompanyDao;
import com.env.dto.DrmCompany;

/**
 * DrmCompany数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Repository("drmCompanyDao")
public class DrmCompanyDao extends DefaultDaoImpl<DrmCompany> implements IDrmCompanyDao<DrmCompany> {
	public List<DrmCompany> queryAllByUserid(Integer userId) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("userId", userId);
		return this.query(getStatement(), map);
	}
}
