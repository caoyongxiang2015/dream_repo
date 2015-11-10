/**
 * Description: DrmNetfriendComment业务实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-11-09 下午 22:58:36
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-11-09   caoyx   1.0         Initial
 */
package com.env.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.env.dao.api.Dao;
import com.env.dao.intf.IDrmNetfriendCommentDao;
import com.env.dto.DrmNetfriendComment;
import com.env.service.impl.DefaultServiceImpl;
import com.env.service.intf.IDrmNetfriendCommentService;

/**
 * DrmNetfriendComment业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-11-09
 * @see
 * @since 1.0
 */
@Service("drmNetfriendCommentService")
public class DrmNetfriendCommentService<T extends DrmNetfriendComment> extends DefaultServiceImpl<T> implements IDrmNetfriendCommentService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmNetfriendCommentDao<DrmNetfriendComment> drmNetfriendCommentDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmNetfriendCommentDao;
	}

	@Override
	public List<DrmNetfriendComment> getByLibId(Integer libId) {
		Map params = new HashMap();
		params.put("libId", libId);
		return drmNetfriendCommentDao.getByLibId(params);
	}
}