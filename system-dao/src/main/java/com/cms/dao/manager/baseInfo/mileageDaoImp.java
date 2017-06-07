package com.cms.dao.manager.baseInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.mileageMapper;
import com.cms.model.manager.mileageBean;

@Component
public class mileageDaoImp implements mileageDao{
	
	@Autowired
	private mileageMapper mileageMapper;

	public mileageBean getInfo(mileageBean bean) {
		
		return this.mileageMapper.getInfo(bean);
	}

	public List<mileageBean> dataGrid(JSONObject obj) {
		
		return this.mileageMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		
		return this.mileageMapper.dataGridCot(obj);
	}

	public void add(mileageBean mileageBean) {
		
		this.mileageMapper.add(mileageBean);
		
	}

	public void delete(JSONObject obj) {
		
		this.mileageMapper.delete(obj);
		
	}

	public mileageBean get(JSONObject obj) {
		
		return this.mileageMapper.get(obj);
	}

	public void edit(mileageBean mileageBean) {
		this.mileageMapper.edit(mileageBean);
	}







}
