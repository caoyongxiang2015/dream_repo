/**
 * Description: DrmTwotag数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:02
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IDrmTwotagDao;
import com.env.dto.DrmTwotag;

/**
 * DrmTwotag数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Repository("drmTwotagDao")
public class DrmTwotagDao extends DefaultDaoImpl<DrmTwotag> implements IDrmTwotagDao<DrmTwotag> {
	public List<DrmTwotag> getByUseridAndOnetagid(Integer userId,Integer onetagId,Integer companyid){
		Map params = new HashMap();
		params.put("userId", userId);
		params.put("onetagId", onetagId);
		params.put("companyId", companyid);
		return this.query(getStatement(), params);
	}
	public void toggletwotag(Integer pk,Integer canprovide){
		Map params = new HashMap();
		params.put("id", pk);
		params.put("canprovide", canprovide);
		this.update(getStatement(), params);
	}
}
