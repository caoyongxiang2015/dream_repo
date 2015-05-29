/**
 * Description: DrmOnetag数据访问接口
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
package com.env.dao.intf;

import java.util.List;

import com.env.dao.api.Dao;
import com.env.dto.DrmOnetag;

/**
 * DrmOnetag数据访问接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public interface IDrmOnetagDao<T extends DrmOnetag> extends Dao<T> {
	public List<DrmOnetag> getonetagid(Integer userid,Integer companyid);
}
