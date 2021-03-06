/**
 * Description: DrmLetter数据访问实现类
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
package com.env.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IDrmLetterDao;
import com.env.dto.DrmLetter;

/**
 * DrmLetter数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Repository("drmLetterDao")
public class DrmLetterDao extends DefaultDaoImpl<DrmLetter> implements IDrmLetterDao<DrmLetter> {

	@Override
	public List<DrmLetter> queryLetter(Map params) {
		return this.query(getStatement(), params);
	}

	@Override
	public List<DrmLetter> letterDetail(Map params) {
		return this.query(getStatement(), params);
	}

	@Override
	public List<DrmLetter> getSysletter(Map params) {
		return this.query(getStatement(), params);}
}
