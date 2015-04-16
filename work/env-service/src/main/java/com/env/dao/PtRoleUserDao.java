/**
 * Description: PtRoleUser数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-01-07 下午 13:35:30
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-01-07   caoyx   1.0         Initial
 */
package com.env.dao;

import org.springframework.stereotype.Repository;
import com.env.dao.impl.DefaultDaoImpl;

import com.env.dao.intf.IPtRoleUserDao;
import com.env.dto.PtRoleUser;

/**
 * PtRoleUser数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
@Repository("ptRoleUserDao")
public class PtRoleUserDao extends DefaultDaoImpl<PtRoleUser> implements IPtRoleUserDao<PtRoleUser> {
}
