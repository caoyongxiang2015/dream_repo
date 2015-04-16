/**
 * Description: PtRole业务接口
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
package com.env.service.intf;

import java.util.List;

import com.env.dto.PtRole;
import com.env.service.impl.Service;

/**
 * PtRole业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
public interface IPtRoleService<T extends PtRole> extends Service<T> {
	/**
	 * 根据用户ID获取用户角色列表
	 * @param userId
	 * @return
	 */
	public List<PtRole> getByUserid(Integer userId);
}