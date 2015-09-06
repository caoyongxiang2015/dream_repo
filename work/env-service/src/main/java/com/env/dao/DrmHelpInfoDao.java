/**
 * Description: TA们都在这里得到了帮助，模拟数据数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:49
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.dao;

import org.springframework.stereotype.Repository;
import com.env.dao.impl.DefaultDaoImpl;

import com.env.dao.intf.IDrmHelpInfoDao;
import com.env.dto.DrmHelpInfo;

/**
 * TA们都在这里得到了帮助，模拟数据数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Repository("drmHelpInfoDao")
public class DrmHelpInfoDao extends DefaultDaoImpl<DrmHelpInfo> implements IDrmHelpInfoDao<DrmHelpInfo> {
}
