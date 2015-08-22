/**
 * Description: PtPermission业务接口
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
package com.env.service.intf;

import java.util.LinkedHashMap;

import com.env.dto.PtPermission;
import com.env.service.impl.Service;

/**
 * PtPermission业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IPtPermissionService<T extends PtPermission> extends Service<T> {

	/**
	 * 根据appCode获取该app下的所有权限
	 * @param appCode 当前就一个APP，appCode暂时忽略，以后扩展
	 * @return
	 */
	public LinkedHashMap<String, String> listPerms(String appCode);

}