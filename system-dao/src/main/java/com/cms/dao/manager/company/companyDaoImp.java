package com.cms.dao.manager.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.company.companyMapper;
import com.cms.model.manager.companyBean;

@Component

public class companyDaoImp implements companyDao{
	
	@Autowired
	private companyMapper companyMapper;

	public companyBean getInfo(JSONObject obj) {
		
		return this.companyMapper.getInfo(obj);
	}

	public List<companyBean> dataGrid(JSONObject obj) {
		
		return this.companyMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.companyMapper.dataGridCot(obj);
	}

	public void add(JSONObject obj) {
		
		this.companyMapper.add(obj);
		
	}

	public void updateFlag(JSONObject obj) {
		
		this.companyMapper.updateFlag(obj);
		
	}

	public companyBean get(Long obj) {
		
		return this.companyMapper.get(obj);
	}

	public void update(JSONObject obj) {
		
		this.companyMapper.update(obj);
		
	}

	public List<companyBean> dataGrid2(JSONObject obj) {
		
		return this.companyMapper.dataGrid2(obj);
	}

    public void updateaudit(JSONObject obj) {

    }

}
