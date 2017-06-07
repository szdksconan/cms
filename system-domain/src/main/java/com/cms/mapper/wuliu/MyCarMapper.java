package com.cms.mapper.wuliu;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.carDicBean;
import com.cms.model.wuliu.MyCarBean;

public interface MyCarMapper {
	
	public List<MyCarBean> getMyCarListByPh(JSONObject obj);
	
	public int getMyCarListCount(JSONObject obj);
	
	public int addCar(MyCarBean myCarBean);
	
	public void addRelative(JSONObject obj);
	
	public List<MyCarBean> getCarDic(Long pid);
	
	public int getCarCount(JSONObject obj);
	
	public void delCarAndRelative(JSONObject obj);
	
	public void delCar(JSONObject obj);
	
	public MyCarBean getId(JSONObject obj);
	
	/**
	 * 查询用户车辆关联关系表
	 * @param obj
	 * @return
	 */
	public List<MyCarBean> getMyCarListByPh2(JSONObject obj);
	/**
	 * 根据车辆Id查询车辆信息
	 */
	public MyCarBean getMyCarById(JSONObject obj);
	
	public carDicBean getDicById(String id);
}
