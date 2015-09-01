/**
 * Description: PtUser数据访问接口
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:53
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.dao.intf;

import java.util.List;

import com.env.dao.api.Dao;
import com.env.dto.PtUser;

/**
 * PtUser数据访问接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IPtUserDao<T extends PtUser> extends Dao<T> {

	PtUser getByLoginid(String loginId);

	boolean isExistLoginid(String loginId);

	PtUser loginUser(String loginId, String password);

	List<PtUser> queryAllByParams(PtUser user);
}
