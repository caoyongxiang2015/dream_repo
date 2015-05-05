/**
 * Description: DrmOnetagLib数据访问实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:02
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.dao;

import org.springframework.stereotype.Repository;
import com.env.dao.impl.DefaultDaoImpl;

import com.env.dao.intf.IDrmOnetagLibDao;
import com.env.dto.DrmOnetagLib;

/**
 * DrmOnetagLib数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Repository("drmOnetagLibDao")
public class DrmOnetagLibDao extends DefaultDaoImpl<DrmOnetagLib> implements IDrmOnetagLibDao<DrmOnetagLib> {
}
