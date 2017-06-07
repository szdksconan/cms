package com.cms.dao.manager.province;


import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.ProvinceBean;

import java.util.List;

public interface provinceDao {
	public ProvinceBean getInfo(ProvinceBean bean);
	
	public List<ProvinceBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(ProvinceBean provinceBean);
	
	public void delete(JSONObject obj);
	
	public ProvinceBean get(JSONObject obj);
	
	public void edit(ProvinceBean provinceBean);
	
	public List<ProvinceBean> getProvinceByType(String q);
	
	public List<ProvinceBean> getProvinceByType2(JSONObject obj);
}
