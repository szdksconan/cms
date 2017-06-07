package com.cms.mapper.manager.baseInfo;


import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.AreaBean;

import java.util.List;

public interface areaMapper {
	public AreaBean getInfo(AreaBean bean);
	
	public List<AreaBean> dataGrid(JSONObject obj);
	
	public int dataGridCot(JSONObject obj);
	
	public void add(AreaBean areaBean);
	
	public void delete(JSONObject obj);
	
	public AreaBean get(String obj);
	
	public void edit(AreaBean areaBean);
	
	public List<AreaBean> selectAreaJson(JSONObject obj);
}
