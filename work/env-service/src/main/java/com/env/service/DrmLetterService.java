/**
 * Description: DrmLetter业务实现类
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.env.dao.api.Dao;
import com.env.dao.intf.IDrmLetterDao;
import com.env.dto.DrmLetter;
import com.env.service.impl.DefaultServiceImpl;
import com.env.service.intf.IDrmLetterService;

/**
 * DrmLetter业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Service("drmLetterService")
public class DrmLetterService<T extends DrmLetter> extends DefaultServiceImpl<T> implements IDrmLetterService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmLetterDao<DrmLetter> drmLetterDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmLetterDao;
	}

	@Override
	public List<DrmLetter> queryLetter(Integer curUserid) {
		Map params = new HashMap();
		params.put("userId", curUserid);
		return drmLetterDao.queryLetter(params);
	}
	@Override
	public List<DrmLetter> letterDetail(Integer myUserId,Integer yourUserId) {
		Map params = new HashMap();
		params.put("myUserId", myUserId);
		params.put("yourUserId", yourUserId);
		return drmLetterDao.letterDetail(params);
	}

	@Override
	public List<DrmLetter> getSysletter(Map params) {
		return drmLetterDao.getSysletter(params);
	}

}