package com.cms.mapper.wuliu;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.MyCarBean;

public interface CarOnlineMapper {
	
	

	
	public List<MyCarBean> searchMap(JSONObject obj);
	
	public void changeFocus(JSONObject obj);
	
	public void changeFocus2(JSONObject obj);
	
	public List<MyCarBean> getMsgListByPh(JSONObject obj);
	
	public int getMsgListCount(JSONObject obj);
	
	public void delMsg(Long id);
	
	public List<MyCarBean> getListByPhMycar(JSONObject obj);
	
	public List<MyCarBean> getListByMapMycar(JSONObject obj);
	
	public int getListCountMycar(JSONObject obj);
	
	public List<MyCarBean> getListByPhMyfocus(JSONObject obj);
	
	public List<MyCarBean> getListByMapMyfocus(JSONObject obj);
	
	public int getListCountMyfocus(JSONObject obj);
	
	public List<MyCarBean> getListByPhAllcar(JSONObject obj);
	
	public int getListCountAllcar(JSONObject obj);
	
	public void updateCarCondition(JSONObject obj);
	
	public void addMSg(JSONObject obj);
	
	public List<MyCarBean> getListByMapAllcar(JSONObject obj);
}
