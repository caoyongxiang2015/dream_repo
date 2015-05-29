/**
 * Description: DrmTwotag业务接口
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
package com.env.service.intf;

import java.util.List;
import java.util.Map;

import com.env.dto.DrmTwotag;
import com.env.service.impl.Service;

/**
 * DrmTwotag业务接口<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
public interface IDrmTwotagService<T extends DrmTwotag> extends Service<T> {
	List<DrmTwotag> getByUseridAndOnetagid(Integer userId,Integer onetagId ,Integer companyid);
	void saveTwotagPatch(Map map);
	void toggletwotag(Integer pk,Integer canprovide);
}