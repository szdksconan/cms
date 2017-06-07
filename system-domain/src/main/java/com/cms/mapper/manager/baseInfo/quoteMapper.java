package com.cms.mapper.manager.baseInfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.quoteBean;

public interface quoteMapper {
	public quoteBean getInfo(quoteBean bean);
	
	public List<quoteBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(quoteBean quoteBean);
	
	public void delete(JSONObject obj);
	
	public quoteBean get(JSONObject obj);
	
	public void edit(quoteBean quoteBean);
}
