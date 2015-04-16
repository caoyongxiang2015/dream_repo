package com.env.web.tags;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.env.dto.PtRole;
import com.env.service.intf.IPtRoleService;

/**
 * 例子：
 * 角色标签
 * 
 */
public class RoleSelectTag extends
        AbstractDomainObjectSelectTag<PtRole> {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
//    @Autowired
//    private IPtRoleService<PtRole> ptRoleService;
    
    @Override
    protected String getDefaultName() {
		return "id";
    }

    @Override
    protected List<PtRole> getList() {
    	IPtRoleService<PtRole> ptRoleService = this.getApplicationContext().getBean(IPtRoleService.class);
    	return ptRoleService.queryAll();
    }

    @Override
    protected String getOptionLabel(PtRole obj) {
        return obj.getRoleName();
    }
}