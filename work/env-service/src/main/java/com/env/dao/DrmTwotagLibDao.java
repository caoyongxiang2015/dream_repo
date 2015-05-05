/**
 * Description: DrmTwotagLib数据访问实现类
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

import com.env.dao.intf.IDrmTwotagLibDao;
import com.env.dto.DrmTwotagLib;

/**
 * DrmTwotagLib数据访问实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Repository("drmTwotagLibDao")
public class DrmTwotagLibDao extends DefaultDaoImpl<DrmTwotagLib> implements IDrmTwotagLibDao<DrmTwotagLib> {
}
