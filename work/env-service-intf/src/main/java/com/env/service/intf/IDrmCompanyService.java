/**
 * Description: 用户注册的公司信息业务接口
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-08-21 下午 22:43:46
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-08-21   caoyx   1.0         Initial
 */
package com.env.service.intf;

import java.util.List;

import com.env.dto.DrmCompany;
import com.env.dto.PtUser;
import com.env.service.impl.Service;

/**
 * 用户注册的公司信息业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-08-21
 * @see
 * @since 1.0
 */
public interface IDrmCompanyService<T extends DrmCompany> extends Service<T> {
	public List<DrmCompany> getByUserid(Integer userid);
	public List<DrmCompany> getByUserid(Integer userid,Integer companyIndex);
	public List<DrmCompany> queryAllByParams(DrmCompany company); 
}