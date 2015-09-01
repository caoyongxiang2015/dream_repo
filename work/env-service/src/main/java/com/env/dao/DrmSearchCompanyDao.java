/**
 * Description: 用户发布需求；搜索公司 都把公司记录下来数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-09-01 下午 21:01:45
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-09-01   caoyx   1.0         Initial
 */
package com.env.dao;

import org.springframework.stereotype.Repository;
import com.env.dao.impl.DefaultDaoImpl;

import com.env.dao.intf.IDrmSearchCompanyDao;
import com.env.dto.DrmSearchCompany;

/**
 * 用户发布需求；搜索公司 都把公司记录下来数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-09-01
 * @see
 * @since 1.0
 */
@Repository("drmSearchCompanyDao")
public class DrmSearchCompanyDao extends DefaultDaoImpl<DrmSearchCompany> implements IDrmSearchCompanyDao<DrmSearchCompany> {
}
