package com.cms.dao.xiaofei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.xiaofei.CmsXLocalDictMapper;
import com.cms.model.xiaofei.CmsXLocalDict;
@Component
public class CmsXLocalDictDaoImpl implements CmsXLocalDictDao {
	
	@Autowired
	private CmsXLocalDictMapper cmsXLocalDictMapper;

	/**
	 * 根据地理位置获取code
	 */
	public CmsXLocalDict selectByLoclCodeGetLoclCode(String localStr) {
		// TODO Auto-generated method stub
		return this.cmsXLocalDictMapper.selectByLoclCodeGetLoclCode(localStr);
	}

}
