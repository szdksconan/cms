package com.cms.dao.wuliu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.wuliu.CarOnlineMapper;
import com.cms.model.wuliu.MyCarBean;

@Component
public class CarOnlineDaoImp implements CarOnlineDao {
	@Autowired
	private CarOnlineMapper carOnlineMapper;



	public List<MyCarBean> searchMap(JSONObject obj) {
		
		return this.carOnlineMapper.searchMap(obj);
		
	}

	public void changeFocus(JSONObject obj) {
		
		this.carOnlineMapper.changeFocus(obj);
		
	}

	public void changeFocus2(JSONObject obj) {
		
		this.carOnlineMapper.changeFocus2(obj);
		
	}

	public List<MyCarBean> getMsgListByPh(JSONObject obj) {
		
		return this.carOnlineMapper.getMsgListByPh(obj);
	}

	public int getMsgListCount(JSONObject obj) {
		
		return this.carOnlineMapper.getMsgListCount(obj);
	}

	public void delMsg(Long id) {
		
		this.carOnlineMapper.delMsg(id);
		
	}

	public List<MyCarBean> getListByPhMycar(JSONObject obj) {
		return this.carOnlineMapper.getListByPhMycar(obj);
	}

	public List<MyCarBean> getListByMapMycar(JSONObject obj) {
		return this.carOnlineMapper.getListByMapMycar(obj);
	}
	
	public int getListCountMycar(JSONObject obj) {
		return this.carOnlineMapper.getListCountMycar(obj);
	}

	public List<MyCarBean> getListByPhMyfocus(JSONObject obj) {
		return this.carOnlineMapper.getListByPhMyfocus(obj);
	}

	public int getListCountMyfocus(JSONObject obj) {
		return this.carOnlineMapper.getListCountMyfocus(obj);
	}

	public List<MyCarBean> getListByPhAllcar(JSONObject obj) {
		
		return this.carOnlineMapper.getListByPhAllcar(obj);
	}

	public int getListCountAllcar(JSONObject obj) {
		return this.carOnlineMapper.getListCountAllcar(obj);
	}

	public void updateCarCondition(JSONObject obj) {
		this.carOnlineMapper.updateCarCondition(obj);
	}

	public void addMSg(JSONObject obj) {
		
		this.carOnlineMapper.addMSg(obj);
		
	}

	public List<MyCarBean> getListByMapAllcar(JSONObject obj) {
		return this.carOnlineMapper.getListByMapAllcar(obj);
	}

	public List<MyCarBean> getListByMapMyfocus(JSONObject obj) {
		return this.carOnlineMapper.getListByMapMyfocus(obj);
	}




}
