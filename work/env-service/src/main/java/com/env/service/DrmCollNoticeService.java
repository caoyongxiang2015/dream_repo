/**
 * Description: 用户提醒平台收录公司业务实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-09-12 下午 17:50:55
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-09-12   caoyx   1.0         Initial
 */
package com.env.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.env.dao.api.Dao;
import com.env.service.impl.DefaultServiceImpl;

import com.env.dao.intf.IDrmCollNoticeDao;
import com.env.service.intf.IDrmCollNoticeService;
import com.env.dto.DrmCollNotice;

/**
 * 用户提醒平台收录公司业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-09-12
 * @see
 * @since 1.0
 */
@Service("drmCollNoticeService")
public class DrmCollNoticeService<T extends DrmCollNotice> extends DefaultServiceImpl<T> implements IDrmCollNoticeService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmCollNoticeDao<DrmCollNotice> drmCollNoticeDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmCollNoticeDao;
	}
}