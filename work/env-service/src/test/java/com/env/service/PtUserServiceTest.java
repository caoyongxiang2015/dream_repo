package com.env.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.env.BaseTest;
import com.env.dto.PtUser;
import com.env.service.intf.IPtUserService;

public class PtUserServiceTest extends BaseTest {

	@Autowired
	private IPtUserService<PtUser> ptUserService;
	
	@Test
	public void testGetUsername() {
		System.out.println("PtUserServiceTest...start");
		List<PtUser> users = ptUserService.queryAll();
		System.out.println("用户数量users.size():"+((users==null)?-1:users.size()));
		System.out.println("PtUserServiceTest...end");
	}
	
	@Test
	@Rollback(false)// 加这句，否则不会主动commit
	public void testSave(){
		PtUser entity = new PtUser();
		entity.setUsername("junit");
		entity.setCompanyId(1);
		entity.setLoginId("junit");
		System.out.println(ptUserService.save(entity));
	}
	
	//@Rollback(false)
	//@Test
	public void test() {
		String str = "张三：zhangsan，李四：lisi";
		
		String []strs = str.split("，");
		
		List<PtUser> us = new ArrayList<PtUser>();
		for(int i=0;i<strs.length;i++){
			
			System.out.println(strs[i]);
			
			String []str2s =strs[i].split("：");
			
			PtUser u = new PtUser();
			u.setUsername(str2s[0]);
			u.setPwd(str2s[1]);
			
			us.add(u);
		}
		
//		ptUserService.cfg_field_category(us);
	}

}
