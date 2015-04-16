/**
 * Description: PtUser业务接口
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
package com.env.service.intf;

import java.util.List;

import com.env.service.impl.Service;
import com.env.dto.PtUser;

/**
 * PtUser业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
public interface IPtUserService<T extends PtUser> extends Service<T> {
	/**
     * 验证用户名是否存在
     * @param loginId 用户名
     * @return true:用户名存在；false:用户名不存在
     */
    public boolean isExistLoginid(String loginId);
    /**
     * 
     * 用户登录
     * 
     * @param name:用户名
     * @param password:密码
     *
     * @return true ：登录成功；false：登录失败
     */
    public PtUser loginUser(String name, String password);
	
    /**
     * 根据登录ID获取用户
     * @param loginId
     * @return
     */
    public PtUser getByLoginid(String loginId);
    }