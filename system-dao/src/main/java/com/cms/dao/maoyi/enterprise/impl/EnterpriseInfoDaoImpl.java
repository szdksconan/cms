package com.cms.dao.maoyi.enterprise.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.dao.maoyi.enterprise.EnterpriseInfoDao;
import com.cms.mapper.maoyi.EnterpriseInfoMapper;
import com.cms.model.maoyi.EnterpriseInfo;


/**
 * @author penglei
 *
 * 2016年4月18日 
 */
@Repository
public class EnterpriseInfoDaoImpl implements EnterpriseInfoDao {

	@Autowired
	private EnterpriseInfoMapper enterpriseInfoMapper;
	
	public void addInfo(EnterpriseInfo enterpriseInfo) {
		enterpriseInfoMapper.addInfo(enterpriseInfo);
	}

	public void deleteInfo(Long id) {
		enterpriseInfoMapper.deleteInfo(id);
	}

	public void updateInfo(EnterpriseInfo enterpriseInfo) {
			enterpriseInfoMapper.updateInfo(enterpriseInfo);
	}

	public EnterpriseInfo getInfo(Long id) {
		return enterpriseInfoMapper.getInfo(id);
	}

	//保存发展意向
	public void addDevelopWill(Map<String, Object> map) {
		enterpriseInfoMapper.addDevelopWill(map);
	}
    //保存合作意向
	public void addJoinWill(Map<String, Object> map) {
			enterpriseInfoMapper.addJoinWill(map);
	}
	public List<Map> getEntByName(String name) {
		return enterpriseInfoMapper.getEntByName(name);
	}

	/**
	 * 设置某个贸易商是否为名品贸易商
	 */
	public void setFamousBrand(Map<String, Object> map) {
		enterpriseInfoMapper.setFamousBrand(map);	
		
	}

	public List<EnterpriseInfo> findEnterInfoBy() {
		return enterpriseInfoMapper.findEnterInfoBy();
	}

}
