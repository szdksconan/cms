package com.cms.mapper.manager.company;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.subCompanyBean;

public interface subCompanyMapper {
	public subCompanyBean getInfo(subCompanyBean bean);
	
	public List<subCompanyBean> dataGrid();
	
	public void add(subCompanyBean subCompanyBean);
	
	public void delete(JSONObject obj);
	
	public subCompanyBean get(Long obj);
	
	public void update(subCompanyBean subCompanyBean);
	
	public List<JSONObject> getRelationDataRole(JSONObject obj);
}
