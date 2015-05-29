/**
 * Description: DrmCompany业务接口
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:00
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.service.intf;

import java.util.List;

import com.env.dto.DrmCompany;
import com.env.dto.DrmDept;
import com.env.service.impl.Service;

/**
 * DrmCompany业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public interface IDrmCompanyService<T extends DrmCompany> extends Service<T> {
	
	Integer saveCompanyAndDept(DrmCompany drmCompany,DrmDept drmDept);
	Integer saveCompanyAndDept(DrmCompany drmCompany, DrmDept drmDept, Integer userId);
	void deleteCompanyAndDept(Integer companyId);
	List<DrmCompany> queryAllByUserid(Integer userId) ;
}