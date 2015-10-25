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

import com.env.dto.DrmCompanyContent;
import com.env.service.impl.Service;

/**
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IDrmCompanyContentService<T extends DrmCompanyContent> extends Service<T> {
	
	public List<DrmCompanyContent> getByCompanyLibId(Integer libid);

}