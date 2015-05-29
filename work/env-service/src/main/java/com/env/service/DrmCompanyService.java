/**
 * Description: DrmCompany业务实现类
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
package com.env.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.env.dao.api.Dao;
import com.env.dao.intf.IDrmCompanyDao;
import com.env.dao.intf.IDrmDeptDao;
import com.env.dto.DrmCompany;
import com.env.dto.DrmDept;
import com.env.dto.DrmOnetag;
import com.env.service.impl.DefaultServiceImpl;
import com.env.service.intf.IDrmCompanyService;
import com.env.service.intf.IDrmOnetagService;

/**
 * DrmCompany业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Service("drmCompanyService")
public class DrmCompanyService<T extends DrmCompany> extends DefaultServiceImpl<T> implements IDrmCompanyService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmCompanyDao<DrmCompany> drmCompanyDao;
	@Autowired
	private IDrmDeptDao<DrmDept> drmDeptDao;
	@Autowired
	private IDrmOnetagService<DrmOnetag> drmOnetagService;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmCompanyDao;
	}

	@Override
	public Integer saveCompanyAndDept(DrmCompany drmCompany, DrmDept drmDept) {
		// 保存公司
		Integer cid = drmCompanyDao.save(drmCompany);
		drmDept.setCompanyId(cid);
		// 保存部门  
		drmDeptDao.save(drmDept);
		
		return cid;
	}

	@Override
	public Integer saveCompanyAndDept(DrmCompany drmCompany, DrmDept drmDept, Integer userId) {
		// 保存公司
		drmCompany.setUserId(userId);
		Integer cid = drmCompanyDao.save(drmCompany);
		drmDept.setCompanyId(cid);
		// 保存部门  
		drmDeptDao.save(drmDept);
		// 保存一级，二级标签
		Map map = new HashMap();
		map.put("userid", userId);
		map.put("companyid", cid);
		drmOnetagService.saveOnetagPatch(map);
		
		return cid;
	}

	@Override
	public void deleteCompanyAndDept(Integer companyId) {
		drmCompanyDao.delete(companyId);
		drmDeptDao.deleteByCompanyId(companyId);
	}

	@Override
	public List<DrmCompany> queryAllByUserid(Integer userId) {
		return drmCompanyDao.queryAllByUserid(userId);
	}

	
}