/**
 * Description: 用户发布需求；搜索公司 都把公司记录下来业务实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-09-01 下午 21:01:45
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-09-01   caoyx   1.0         Initial
 */
package com.env.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.env.dao.api.Dao;
import com.env.service.impl.DefaultServiceImpl;

import com.env.dao.intf.IDrmSearchCompanyDao;
import com.env.service.intf.IDrmSearchCompanyService;
import com.env.dto.DrmSearchCompany;

/**
 * 用户发布需求；搜索公司 都把公司记录下来业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-09-01
 * @see
 * @since 1.0
 */
@Service("drmSearchCompanyService")
public class DrmSearchCompanyService<T extends DrmSearchCompany> extends DefaultServiceImpl<T> implements IDrmSearchCompanyService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmSearchCompanyDao<DrmSearchCompany> drmSearchCompanyDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmSearchCompanyDao;
	}
}