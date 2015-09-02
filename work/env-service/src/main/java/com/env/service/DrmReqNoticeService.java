/**
 * Description: 给哪些用户发需求通知，我接收到的需求业务实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:50
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
import com.env.dao.intf.IDrmReqNoticeDao;
import com.env.dto.DrmReqNotice;
import com.env.service.impl.DefaultServiceImpl;
import com.env.service.intf.IDrmReqNoticeService;

/**
 * 给哪些用户发需求通知，我接收到的需求业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Service("drmReqNoticeService")
public class DrmReqNoticeService<T extends DrmReqNotice> extends DefaultServiceImpl<T> implements IDrmReqNoticeService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmReqNoticeDao<DrmReqNotice> drmReqNoticeDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmReqNoticeDao;
	}
	

	public List<DrmReqNotice> queryByParams(DrmReqNotice entity){
		Map params = new HashMap();
		params.put("entity", entity);
		return drmReqNoticeDao.queryByParams(params);
	}
}