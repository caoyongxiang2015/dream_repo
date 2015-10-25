/**
 * Description: 用户注册的公司信息业务实现类
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
package com.env.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.env.dao.api.Dao;
import com.env.dao.intf.IDrmCompanyContentDao;
import com.env.dto.DrmCompanyContent;
import com.env.service.impl.DefaultServiceImpl;
import com.env.service.intf.IDrmCompanyContentService;

/**
 * 用户注册的公司信息业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Service("drmCompanyContentService")
public class DrmCompanyContentService<T extends DrmCompanyContent> extends DefaultServiceImpl<T> implements IDrmCompanyContentService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmCompanyContentDao<DrmCompanyContent> drmCompanyContentDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmCompanyContentDao;
	}

	@Override
	public List<DrmCompanyContent> getByCompanyLibId(Integer libid) {
		Map params = new HashMap();
		params.put("companyLibId", libid);
		return drmCompanyContentDao.getByCompanyLibId(params);
	}
}