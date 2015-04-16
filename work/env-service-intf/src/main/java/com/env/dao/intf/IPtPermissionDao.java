/**
 * Description: PtPermission数据访问接口
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-01-07 下午 13:35:29
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-01-07   caoyx   1.0         Initial
 */
package com.env.dao.intf;

import java.util.List;

import com.env.dao.api.Dao;
import com.env.dto.PtPermission;

/**
 * PtPermission数据访问接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
public interface IPtPermissionDao<T extends PtPermission> extends Dao<T> {
	/**
	 * 根据appId获取该app下的权限列表
	 * @param appId
	 * @return
	 */
	public List<PtPermission> getByAppid(Integer appId);
}
