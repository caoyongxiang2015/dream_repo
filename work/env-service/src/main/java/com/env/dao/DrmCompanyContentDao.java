/**
 * Description: 用户注册的公司信息数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:46
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IDrmCompanyContentDao;
import com.env.dto.DrmCompanyContent;

/**
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Repository("drmCompanyContentDao")
public class DrmCompanyContentDao extends DefaultDaoImpl<DrmCompanyContent> implements IDrmCompanyContentDao<DrmCompanyContent> {

	@Override
	public List<DrmCompanyContent> getByCompanyLibId(Map params) {
		return this.query(getStatement(), params);
	}
}
