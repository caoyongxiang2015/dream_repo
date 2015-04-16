/**
 * Description: PtUser数据访问接口
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
package com.env.dao.intf;

import java.util.List;

import com.env.dao.api.Dao;
import com.env.dto.PtUser;

/**
 * PtUser数据访问接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
public interface IPtUserDao<T extends PtUser> extends Dao<T> {

	/**
	 * 判断登陆账号是否存在
	 * @param loginId
	 * @return
	 */
	public boolean isExistLoginid(String loginId) ;
	

	/**
	 * 登录验证
	 * @param name
	 * @param password
	 * @return
	 */
	public PtUser loginUser(String name, String password);
	

    /**
     * 根据登录ID获取用户
     * @param loginId
     * @return
     */
    public PtUser getByLoginid(String loginId);
    
}
