package com.env.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.env.BaseTest;
import com.env.dto.PtRole;
import com.env.service.intf.IPtRoleService;

public class PtRoleServiceTest extends BaseTest {

	@Autowired
	private IPtRoleService<PtRole> ptRoleService;
	
	@Test
	public void testGetById() {
		PtRole role = ptRoleService.getById(1);
		System.out.println("testGetById id=1:"+role.getRoleName());
	}

	@Test
	public void testQueryAll() {
		List<PtRole> roles = ptRoleService.queryAll();
		System.out.println("testQueryAll size():"+roles.size());
	}

}
