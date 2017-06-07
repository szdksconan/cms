package com.cms.dao.manager.province;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.province.provinceMapper;
import com.cms.model.wuliu.ProvinceBean;

@Component
public class provinceDaoImp implements provinceDao{
	@Autowired
	private provinceMapper provinceMapper;

	public ProvinceBean getInfo(ProvinceBean bean) {
		return this.provinceMapper.getInfo(bean);
	}

	public List<ProvinceBean> dataGrid(JSONObject obj) {
		return this.provinceMapper.dataGrid(obj);
	}

	public int dataGridCot(JSONObject obj) {
		return this.provinceMapper.dataGridCot(obj);
	}

	public void add(ProvinceBean provinceBean) {
		this.provinceMapper.add(provinceBean);
	}

	public void delete(JSONObject obj) {
		this.provinceMapper.delete(obj);
	}

	public ProvinceBean get(JSONObject obj) {
		return this.provinceMapper.get(obj);
	}

	public void edit(ProvinceBean provinceBean) {
		this.provinceMapper.edit(provinceBean);
	}

	public List<ProvinceBean> getProvinceByType(String q) {
		return this.provinceMapper.getProvinceByType(q);
	}

	public List<ProvinceBean> getProvinceByType2(JSONObject obj) {
		return this.provinceMapper.getProvinceByType2(obj);
	}

}
