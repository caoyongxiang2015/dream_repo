/**
 * Description: 用户注册的部门信息数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:48
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.dao;

import org.springframework.stereotype.Repository;
import com.env.dao.impl.DefaultDaoImpl;

import com.env.dao.intf.IDrmDeptDao;
import com.env.dto.DrmDept;

/**
 * 用户注册的部门信息数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
@Repository("drmDeptDao")
public class DrmDeptDao extends DefaultDaoImpl<DrmDept> implements IDrmDeptDao<DrmDept> {
}
