package com.cms.dao.manager.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.company.subCompanyMapper;
import com.cms.model.manager.subCompanyBean;

@Component

public class subCompanyDaoImp implements subCompanyDao{
	
	@Autowired
	private subCompanyMapper subCompanyMapper;

	public subCompanyBean getInfo(subCompanyBean bean) {
		
		return this.subCompanyMapper.getInfo(bean);
	}

	public List<subCompanyBean> dataGrid() {
		
		return this.subCompanyMapper.dataGrid();
	}

	public void add(subCompanyBean subCompanyBean) {
		
		this.subCompanyMapper.add(subCompanyBean);
		
	}

	public void delete(JSONObject obj) {
		
		this.subCompanyMapper.delete(obj);
		
	}

	public subCompanyBean get(Long obj) {
		
		return this.subCompanyMapper.get(obj);
	}

	public void update(subCompanyBean subCompanyBean) {
		
		this.subCompanyMapper.update(subCompanyBean);
		
	}

	public List<JSONObject> getRelationDataRole(JSONObject obj) {
		
		return this.subCompanyMapper.getRelationDataRole(obj);
	}



}
