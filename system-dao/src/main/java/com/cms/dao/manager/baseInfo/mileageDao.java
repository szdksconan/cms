package com.cms.dao.manager.baseInfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.mileageBean;

public interface mileageDao {
	public mileageBean getInfo(mileageBean bean);
	
	public List<mileageBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(mileageBean mileageBean);
	
	public void delete(JSONObject obj);
	
	public mileageBean get(JSONObject obj);
	
	public void edit(mileageBean mileageBean);
}
