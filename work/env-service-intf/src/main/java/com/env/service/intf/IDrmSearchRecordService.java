/**
 * Description: 记录用户对公司的搜索次数业务接口
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

import com.env.service.impl.Service;
import com.env.dto.DrmSearchRecord;

/**
 * 记录用户对公司的搜索次数业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IDrmSearchRecordService<T extends DrmSearchRecord> extends Service<T> {
}