/**
 * Description: DrmOnetag业务实现类
 * Copyright:   Copyright (c)2015
 * Company:     envbase
 * @author:     caoyx
 * @version:    1.0
 * Create at:   2015-05-05 下午 21:27:01
 *  
 * Modification History:
 * Date         Author      Version     Description
 * ------------------------------------------------------------------
 * 2015-05-05   caoyx   1.0         Initial
 */
package com.env.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.env.dao.api.Dao;
import com.env.dao.intf.IDrmOnetagDao;
import com.env.dto.DrmOnetag;
import com.env.dto.DrmTwotag;
import com.env.service.impl.DefaultServiceImpl;
import com.env.service.intf.IDrmOnetagService;
import com.env.service.intf.IDrmTwotagService;

/**
 * DrmOnetag业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Service("drmOnetagService")
public class DrmOnetagService<T extends DrmOnetag> extends DefaultServiceImpl<T> implements IDrmOnetagService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmOnetagDao<DrmOnetag> drmOnetagDao;

	@Autowired
	private IDrmTwotagService<DrmTwotag> drmTwotagService;
	
	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmOnetagDao;
	}

	@Override
	public void saveOnetagPatch(Map map){

		DrmOnetag onetag1 = new DrmOnetag();
		
		onetag1.setCanprovide(0);
		onetag1.setCreateUserid((Integer)map.get("userid"));
		onetag1.setDisabled(0);
		onetag1.setCompanyid((Integer)map.get("companyid"));
		onetag1.setUserid((Integer)map.get("userid"));
		onetag1.setVersion(0);
		
		// 公司信息
		onetag1.setTagname("公司信息");
		onetag1.setOnetaglibid(1);
		Integer onetagid_gs = drmOnetagDao.save(onetag1);

		// 部门信息
		onetag1.setId(null);
		onetag1.setTagname("部门信息");
		onetag1.setOnetaglibid(2);
		Integer onetagid_bm = drmOnetagDao.save(onetag1);

		onetag1.setId(null);
		onetag1.setTagname("项目信息");
		onetag1.setOnetaglibid(3);
		Integer onetagid_xm = drmOnetagDao.save(onetag1);

		onetag1.setId(null);
		onetag1.setTagname("制度信息");
		onetag1.setOnetaglibid(4);
		Integer onetagid_zd = drmOnetagDao.save(onetag1);

		onetag1.setId(null);
		onetag1.setTagname("招聘信息");
		onetag1.setOnetaglibid(5);
		Integer onetagid_zp = drmOnetagDao.save(onetag1);

		onetag1.setId(null);
		onetag1.setTagname("福利待遇信息");
		onetag1.setOnetaglibid(6);
		Integer onetagid_fl = drmOnetagDao.save(onetag1);

		onetag1.setId(null);
		onetag1.setTagname("其他信息");
		onetag1.setOnetaglibid(7);
		Integer onetagid_qt = drmOnetagDao.save(onetag1);
		
		map.put("onetagid_gs", onetagid_gs);
		map.put("onetagid_bm", onetagid_bm);
		map.put("onetagid_xm", onetagid_xm);
		map.put("onetagid_zd", onetagid_zd);
		map.put("onetagid_zp", onetagid_zp);
		map.put("onetagid_fl", onetagid_fl);
		map.put("onetagid_qt", onetagid_qt);
		
		drmTwotagService.saveTwotagPatch(map);
	}

	@Override
	public List<DrmOnetag> getonetagid(Integer userid,Integer companyid ) {
		return drmOnetagDao.getonetagid(userid, companyid);
	}
}