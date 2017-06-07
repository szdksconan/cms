package com.cms.dao.manager.baseInfo;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.manager.baseInfo.carMapper;
import com.cms.model.wuliu.CarBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class carDaoImp implements carDao{
	@Autowired
	private carMapper carMapper;
	
    public CarBean getInfo(CarBean bean) {
        return this.carMapper.getInfo(bean);
    }

    public List<CarBean> dataGrid(JSONObject obj) {
        return this.carMapper.dataGrid(obj);
    }

    public int dataGridCot(JSONObject obj) {
        return this.carMapper.dataGridCot(obj);
    }

    public List<CarBean> dataGrid2(JSONObject obj) {
        return this.carMapper.dataGrid2(obj);
    }

    public void add(CarBean carBean) {
    	this.carMapper.add(carBean);
    }

    public void delete(JSONObject obj) {
    	this.carMapper.delete(obj);
    }

    public CarBean get(Long obj) {
        return this.carMapper.get(obj);
    }

    public void edit(CarBean carBean) {
    	this.carMapper.edit(carBean);
    }

    public List<CarBean> dataGrid3(JSONObject obj) {
        return this.carMapper.dataGrid3(obj);
    }
}
