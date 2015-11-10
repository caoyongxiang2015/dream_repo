/**
 * Description: DrmNetfriendComment数据访问实现类
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
package com.env.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IDrmNetfriendCommentDao;
import com.env.dto.DrmNetfriendComment;

/**
 * DrmNetfriendComment数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-11-09
 * @see
 * @since 1.0
 */
@Repository("drmNetfriendCommentDao")
public class DrmNetfriendCommentDao extends DefaultDaoImpl<DrmNetfriendComment>
		implements IDrmNetfriendCommentDao<DrmNetfriendComment> {

	@Override
	public List<DrmNetfriendComment> getByLibId(Map params) {
		return this.query(getStatement(), params);
	}
}
