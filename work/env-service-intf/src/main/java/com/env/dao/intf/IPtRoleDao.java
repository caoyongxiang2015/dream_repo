/**
 * Description: PtRole数据访问接口
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:51
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.dao.intf;

import java.util.List;

import com.env.dao.api.Dao;
import com.env.dto.PtRole;

/**
 * PtRole数据访问接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IPtRoleDao<T extends PtRole> extends Dao<T> {
	/**
	 * 根据用户ID获取用户角色列表
	 * @param userId
	 * @return
	 */
	public List<PtRole> getByUserid(Integer userId);

}
