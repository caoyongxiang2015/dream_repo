/**
 * Description: 需求业务接口
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:50
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.service.intf;

import java.util.List;
import java.util.Map;

import com.env.dto.DrmReq;
import com.env.service.impl.Service;

/**
 * 需求业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IDrmReqService<T extends DrmReq> extends Service<T> {
	
	List<DrmReq> queryByParams(DrmReq req);
	int releaseCount(Integer userid,String format,String companyname);
}