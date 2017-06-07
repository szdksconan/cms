package com.cms.mapper.manager.baseInfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.messageLogBean;

public interface messageLogMapper {
	public messageLogBean getInfo(messageLogBean bean);
	
	public List<messageLogBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(messageLogBean messageLogBean);
	
	public void delete(JSONObject obj);
	
	public messageLogBean get(Long obj);
	
	public void edit(messageLogBean messageLogBean);
}
