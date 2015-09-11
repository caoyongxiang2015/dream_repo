/**
 * Description: 公司库，搜索使用业务接口
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:47
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.service.intf;

import java.util.List;

import com.env.dto.DrmCompanyLib;
import com.env.service.impl.Service;

/**
 * 公司库，搜索使用业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IDrmCompanyLibService<T extends DrmCompanyLib> extends Service<T> {
	
	/**
	 * 根据公司名称查询
	 * @param name
	 * @return
	 */
	public List<DrmCompanyLib> queryByParams(String name);
}