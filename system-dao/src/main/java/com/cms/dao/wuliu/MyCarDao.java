package com.cms.dao.wuliu;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.carDicBean;
import com.cms.model.wuliu.AreaBean;
import com.cms.model.wuliu.MyCarBean;



public interface MyCarDao {
	
	public List<MyCarBean> getMyCarListByPh(JSONObject obj);
	
	public int getMyCarListCount(JSONObject obj);
	
	public int addCar(MyCarBean myCarBean);
	
	public void addRelative(JSONObject obj);
	
	public List<MyCarBean> getCarDic(Long pid);
	
	public int getCarCount(JSONObject obj);
	
	public void delCarAndRelative(JSONObject obj);
	
	public void delCar(JSONObject obj);
	
	public MyCarBean getId(JSONObject obj);
	
	public carDicBean getDicById(String id);
	
}
