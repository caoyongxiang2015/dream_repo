/**
 * Description: 用户发布需求；搜索公司 都把公司记录下来数据访问接口
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
package com.env.dao.intf;

import com.env.dao.api.Dao;

import com.env.dto.DrmSearchCompany;

/**
 * 用户发布需求；搜索公司 都把公司记录下来数据访问接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-09-01
 * @see
 * @since 1.0
 */
public interface IDrmSearchCompanyDao<T extends DrmSearchCompany> extends Dao<T> {
}
