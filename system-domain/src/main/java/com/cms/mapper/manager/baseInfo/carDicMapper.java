package com.cms.mapper.manager.baseInfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.carDicBean;

public interface carDicMapper {
	
	public List<carDicBean> dataGrid(JSONObject obj);
	
	public void add(carDicBean bean);
	
	public carDicBean get(JSONObject obj);
	
	public void update(JSONObject obj);
}
