/**
 * Description: 用户注册的公司信息数据访问接口
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:46
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.dao.intf;

import java.util.List;
import java.util.Map;

import com.env.dao.api.Dao;
import com.env.dto.DrmCompany;

/**
 * 用户注册的公司信息数据访问接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IDrmCompanyDao<T extends DrmCompany> extends Dao<T> {
	public List<DrmCompany> getByUserid(Map params);
	public List<DrmCompany> queryAllByParams(DrmCompany company); 
}
