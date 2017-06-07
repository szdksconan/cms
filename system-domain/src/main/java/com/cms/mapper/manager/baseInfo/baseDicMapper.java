package com.cms.mapper.manager.baseInfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.baseDicBean;

public interface baseDicMapper {
	public baseDicBean getInfo(baseDicBean bean);
	
	public List<baseDicBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(baseDicBean baseDicBean);
	
	public void delete(JSONObject obj);
	
	public baseDicBean get(Long obj);
	
	public void edit(baseDicBean baseDicBean);
	
	public List<baseDicBean> getAllDic(JSONObject obj);
	
	public List<baseDicBean> getByPid(JSONObject obj);
}
