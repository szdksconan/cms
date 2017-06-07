package com.cms.dao.wuliu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.wuliu.MyCarMapper;
import com.cms.model.manager.carDicBean;
import com.cms.model.wuliu.MyCarBean;

@Component
public class MyCarDaoImp  implements MyCarDao{
	
	@Autowired
	private MyCarMapper MyCarMapper;

	public List<MyCarBean> getMyCarListByPh(JSONObject obj) {
		return this.MyCarMapper.getMyCarListByPh(obj);
	}

	public int getMyCarListCount(JSONObject obj) {
	
		return this.MyCarMapper.getMyCarListCount(obj);
	}

	public int addCar(MyCarBean myCarBean) {
		
		return this.MyCarMapper.addCar(myCarBean);
	}

	public void addRelative(JSONObject obj) {
		
		this.MyCarMapper.addRelative(obj);
		
	}

	public List<MyCarBean> getCarDic(Long pid) {
	
		return this.MyCarMapper.getCarDic(pid);
	}

	public int getCarCount(JSONObject obj) {
	
		return this.MyCarMapper.getCarCount(obj);
	}

	public void delCarAndRelative(JSONObject obj) {
		
		this.MyCarMapper.delCarAndRelative(obj);
		
	}

	public void delCar(JSONObject obj) {
	
		this.MyCarMapper.delCar(obj);
		
	}
	
	public MyCarBean getId(JSONObject obj){
		return this.MyCarMapper.getId(obj);
	}

	public carDicBean getDicById(String id) {
		return this.MyCarMapper.getDicById(id);
	}





}
