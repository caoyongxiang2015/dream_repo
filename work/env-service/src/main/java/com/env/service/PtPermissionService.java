/**
 * Description: PtPermission业务实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-01-07 下午 13:52:24
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-01-07   caoyx   1.0         Initial
 */
package com.env.service;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.env.dao.api.Dao;
import com.env.dao.intf.IPtPermissionDao;
import com.env.dto.PtPermission;
import com.env.service.impl.DefaultServiceImpl;
import com.env.service.intf.IPtPermissionService;

/**
 * PtPermission业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-01-07
 * @see
 * @since 1.0
 */
@Service("ptPermissionService")
public class PtPermissionService<T extends PtPermission> extends DefaultServiceImpl<T> implements IPtPermissionService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IPtPermissionDao ptPermissionDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) ptPermissionDao;
	}
	

	@Override
	public LinkedHashMap<String, String> listPerms(String appCode) {
		// appCode->App->appId
		Integer appId = 1;// 此处appId固定为1,以后生产另外的app再根据appCode获取app
		List<PtPermission> permissions = ptPermissionDao.getByAppid(appId);

        LinkedHashMap<String, String> result = new LinkedHashMap<String, String>();
		for (PtPermission permission : permissions) {
			
            String resource = permission.getResource();
            String code = permission.getPermissionCode();
            String perm = "authc,perms[\"" + code + "\"]";// 例如 perms["MENU_USER"]
            
            // TODO 该值应该取自权限配置表，目前没有，全部用*，表示适配所有的方法
            String method = "*";
            if(null!=resource){
	            if (resource.contains(",")) {
	                String[] resources = resource.split(",");
	                for (String subResource : resources) {
	                    //result.put(method + "@" + subResource, perm);
//	                	result.put(subResource, "authc");
	                	result.put(subResource, perm);
	                }
	            } else {
//	                result.put(method + "@" + resource, perm);
//                	result.put(resource, "authc");
	                result.put(resource, perm);
	            }
            }
        }
		return result;
	}

}