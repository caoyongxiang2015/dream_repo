/**
 * Description: PtUser业务接口
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
package com.env.service.intf;

import com.env.service.impl.Service;
import com.env.dto.PtUser;

/**
 * PtUser业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IPtUserService<T extends PtUser> extends Service<T> {

	boolean isExistLoginid(String loginId);

	PtUser loginUser(String loginId, String password);

	PtUser getByLoginid(String loginId);

}