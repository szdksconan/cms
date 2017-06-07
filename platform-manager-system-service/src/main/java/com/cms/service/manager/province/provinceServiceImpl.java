package com.cms.service.manager.province;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.manager.province.provinceService;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.ProvinceBean;
import com.cms.dao.manager.province.provinceDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class provinceServiceImpl implements provinceService {
	@Autowired
	private provinceDao provinceDao;
	
	//@Autowired
	//private GlobalIdService globalIdService;

	public ProvinceBean getInfo(ProvinceBean bean) {
		return this.provinceDao.getInfo(bean);
	}

	public Grid dataGrid(ProvinceBean provinceBean, PageFilter ph) {
		
		//Long id = this.globalIdService.getGlobalId();
		JSONObject obj = (JSONObject) JSONObject.toJSON(provinceBean);
		obj.put("order", ph.getOrderString());
		Grid grid = new Grid();
		grid.setRows(this.provinceDao.dataGrid(obj));
		grid.setTotal(this.provinceDao.dataGridCot(obj));
		return grid;
	}

	public void add(ProvinceBean provinceBean) {
		this.provinceDao.add(provinceBean);

	}

	public void delete(String id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		this.provinceDao.delete(obj);
	}

	public ProvinceBean get(String id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		return	this.provinceDao.get(obj);
	}

	public void edit(ProvinceBean provinceBean) {
		this.provinceDao.edit(provinceBean);
	}

	public List<ProvinceBean> getProvinceByType(String q) {

		return this.provinceDao.getProvinceByType(q);
	}

	public List<ProvinceBean> getProvinceByType2(String q,String pid1) {
		JSONObject obj = new JSONObject();
		obj.put("q",q);
		obj.put("pid1", pid1);
		return this.provinceDao.getProvinceByType2(obj);
	}
}
