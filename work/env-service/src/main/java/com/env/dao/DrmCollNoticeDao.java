/**
 * Description: 用户提醒平台收录公司数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-09-12 下午 17:50:55
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-09-12   caoyx   1.0         Initial
 */
package com.env.dao;

import org.springframework.stereotype.Repository;
import com.env.dao.impl.DefaultDaoImpl;

import com.env.dao.intf.IDrmCollNoticeDao;
import com.env.dto.DrmCollNotice;

/**
 * 用户提醒平台收录公司数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-09-12
 * @see
 * @since 1.0
 */
@Repository("drmCollNoticeDao")
public class DrmCollNoticeDao extends DefaultDaoImpl<DrmCollNotice> implements IDrmCollNoticeDao<DrmCollNotice> {
}
