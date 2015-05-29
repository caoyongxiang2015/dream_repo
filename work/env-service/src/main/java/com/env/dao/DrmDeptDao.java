/**
 * Description: DrmDept数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:01
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.env.dao.impl.DefaultDaoImpl;
import com.env.dao.intf.IDrmDeptDao;
import com.env.dto.DrmDept;

/**
 * DrmDept数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Repository("drmDeptDao")
public class DrmDeptDao extends DefaultDaoImpl<DrmDept> implements IDrmDeptDao<DrmDept> {

	@Override
	public void deleteByCompanyId(Integer id) {
		Map params = new HashMap();
		params.put("companyId", id);
		this.delete(getStatement(), params);
	}
}
