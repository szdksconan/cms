package com.cms.dao.maoyi.enterprise.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.dao.maoyi.enterprise.EnterQualifDao;
import com.cms.mapper.maoyi.EnterpriseQualificationMapper;
import com.cms.model.maoyi.EnterpriseQualification;
import com.cms.model.maoyi.TradeImage;

@Repository
public class EnterQualifDaoImpl implements EnterQualifDao {

	@Autowired
	private EnterpriseQualificationMapper enterQualifMapper;
	
	public void deleteQualif(Long id) {
          enterQualifMapper.deleteQualif(id);
	}

	public void addQualif(EnterpriseQualification enterQualif) {
		enterQualifMapper.addQualif(enterQualif);
	}

	public List<EnterpriseQualification> getAllQualif(Long id) {
		return enterQualifMapper.getAllQualif(id);
	}

	public void updateQualif(EnterpriseQualification enterQualif) {
           enterQualifMapper.updateQualif(enterQualif);
	}

	//拿到对应id的资质信息
	public EnterpriseQualification getQualif(Long id) {
		return enterQualifMapper.getQulif(id);
	}


}
