package com.env.web.tags;


import org.springframework.beans.factory.annotation.Autowired;

import com.env.dto.PtRole;
import com.env.service.intf.IPtRoleService;

/**
 * 
 * @author caoyongxiang
 *
 */
public class RoleViewTag extends AbstractViewTag {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
//    @Autowired
//    private IPtRoleService<PtRole> ptRoleService;

    @Override
    protected String getShowValue() {

    	IPtRoleService<PtRole> ptRoleService = this.getApplicationContext().getBean(IPtRoleService.class);
        if (null == value) {
            return DEFAULT_SHOW_VALUE;
        }
        PtRole role = null;
        try {
            role = ptRoleService.getById(value);
        } catch (Exception e) {
        	e.printStackTrace();
        }


        if (null != role) {
            return role.getRoleName();
        } else {
            return DEFAULT_SHOW_VALUE;
        }
    }
}