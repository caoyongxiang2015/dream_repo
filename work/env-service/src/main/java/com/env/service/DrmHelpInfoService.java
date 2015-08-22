/**
 * Description: TA们都在这里得到了帮助，模拟数据业务实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:49
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
import com.env.service.impl.DefaultServiceImpl;

import com.env.dao.intf.IDrmHelpInfoDao;
import com.env.service.intf.IDrmHelpInfoService;
import com.env.dto.DrmHelpInfo;

/**
 * TA们都在这里得到了帮助，模拟数据业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Service("drmHelpInfoService")
public class DrmHelpInfoService<T extends DrmHelpInfo> extends DefaultServiceImpl<T> implements IDrmHelpInfoService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmHelpInfoDao<DrmHelpInfo> drmHelpInfoDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmHelpInfoDao;
	}
}