package com.cms.dao.manager.baseInfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.premiumBean;

public interface premiumDao {
	public premiumBean getInfo(premiumBean bean);
	
	public List<premiumBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(premiumBean premiumBean);
	
	public void delete(JSONObject obj);
	
	public premiumBean get(Long obj);
	
	public void edit(premiumBean premiumBean);
}
