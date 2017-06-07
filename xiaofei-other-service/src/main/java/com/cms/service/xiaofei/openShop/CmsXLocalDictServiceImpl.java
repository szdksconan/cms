package com.cms.service.xiaofei.openShop;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsXLocalDictDao;
import com.cms.iservice.xiaofei.CmsXLocalDictService;
import com.cms.model.xiaofei.CmsXLocalDict;

public class CmsXLocalDictServiceImpl implements CmsXLocalDictService {
	
	@Autowired
	private CmsXLocalDictDao cmsXLocalDictDao;

	/**
	 * 根据地理位置获取code
	 */
	public CmsXLocalDict selectByLoclCodeGetLoclCode(@Param("localStr")String localStr) {
		// TODO Auto-generated method stub
		return this.cmsXLocalDictDao.selectByLoclCodeGetLoclCode(localStr);
	}

}
