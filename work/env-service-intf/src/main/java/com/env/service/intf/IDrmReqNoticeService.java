/**
 * Description: 给哪些用户发需求通知，我接收到的需求业务接口
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

import com.env.service.impl.Service;
import com.env.dto.DrmReqNotice;

/**
 * 给哪些用户发需求通知，我接收到的需求业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IDrmReqNoticeService<T extends DrmReqNotice> extends Service<T> {
}