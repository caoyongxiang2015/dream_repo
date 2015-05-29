/**
 * Description: DrmTwotag业务实现类
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
package com.env.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.env.dao.api.Dao;
import com.env.service.impl.DefaultServiceImpl;
import com.env.dao.intf.IDrmTwotagDao;
import com.env.service.intf.IDrmTwotagService;
import com.env.dto.DrmOnetag;
import com.env.dto.DrmTwotag;

/**
 * DrmTwotag业务实现类<br>
 * 
 * @author caoyx
 * @version 1.0, 2015-05-05
 * @see
 * @since 1.0
 */
@Service("drmTwotagService")
public class DrmTwotagService<T extends DrmTwotag> extends DefaultServiceImpl<T> implements IDrmTwotagService<T> {
	/**
	 * 自动注入的数据访问对象
	 */
	@Autowired
	private IDrmTwotagDao<DrmTwotag> drmTwotagDao;

	@Override
	protected Dao<T> getDao() {
		return (Dao<T>) drmTwotagDao;
	}

	public List<DrmTwotag> getByUseridAndOnetagid(Integer userId,Integer onetagId ,Integer companyid){
		return drmTwotagDao.getByUseridAndOnetagid(userId, onetagId,companyid);
	}

	public void toggletwotag(Integer pk,Integer canprovide){
		drmTwotagDao.toggletwotag(pk, canprovide);
	}

	@Override
	public void saveTwotagPatch(Map map){

		DrmTwotag twotag1 = new DrmTwotag();
		
		twotag1.setCanprovide(0);
		twotag1.setCreateUserid((Integer)map.get("userid"));
		twotag1.setDisabled(0);
		twotag1.setCompanyid((Integer)map.get("companyid"));
		twotag1.setUserid((Integer)map.get("userid"));
		twotag1.setVersion(0);
		
		// 公司信息 ==========================
		twotag1.setOnetagname("公司信息");
		twotag1.setOnetagid((Integer)map.get("onetagid_gs"));

		twotag1.setId(null);
		twotag1.setTagname("公司名称");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("公司规模");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("老板怎么样");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);

		twotag1.setId(null);
		twotag1.setTagname("公司优点");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("公司缺点");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("公司地址");
		twotag1.setRownum(2);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("公司软文化");
		twotag1.setRownum(2);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("男女员工大概比例");
		twotag1.setRownum(2);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("公司照片");
		twotag1.setRownum(2);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("其他");
		twotag1.setRownum(2);
		drmTwotagDao.save(twotag1);
		// 公司信息 ==========================

		// 制度信息 ==========================
		twotag1.setOnetagname("制度信息");
		twotag1.setOnetagid((Integer)map.get("onetagid_zd"));

		twotag1.setId(null);
		twotag1.setTagname("制度信息制度信息1");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("制度信息2");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("制度信息2");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("制度信息3");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("制度信息4");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);
		
		twotag1.setId(null);
		twotag1.setTagname("制度信息5制度信息25555");
		twotag1.setRownum(1);
		drmTwotagDao.save(twotag1);
		// 制度信息 ==========================
		
		
	}
}