package com.cms.service.manager.driver;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.driver.driverService;
import com.cms.model.manager.driverBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.dao.manager.driver.driverDao;
import com.cms.iservice.manager.cargoods.accountService;
import com.cms.iservice.manager.cargoods.loginUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class driverServiceImpl implements driverService {
	@Autowired
	private driverDao driverDao;

	@Autowired
	private accountService accountService;

	@Autowired
	private loginUserService loginUserService;

	public driverBean getInfo(driverBean bean) {
		return this.driverDao.getInfo(bean);
	}

	public Grid dataGrid(driverBean driverBean, PageFilter ph) {
		JSONObject obj = (JSONObject) JSONObject.toJSON(driverBean);
		obj.put("order", ph.getOrderString());
		Grid grid = new Grid();
		grid.setRows(this.driverDao.dataGrid(obj));
		grid.setTotal(this.driverDao.dataGridCot(obj));
		return grid;
	}

	public void add(JSONObject obj)throws Exception {
		if (this.driverDao.get(obj)!=null){
			throw new Exception("该手机号已经注册！");
		}
		this.driverDao.add(obj);
		JSONObject obj2 = new JSONObject();
		obj2.put("id", obj.get("login"));
		obj2.put("sessionId", obj.get("sessionId"));
		obj2.put("accountType", "3002");
		loginUserService.insert(obj2);
		accountService.insert(obj2);
	}

	public void delete(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		this.driverDao.delete(obj);
	}

	public driverBean get(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		return	this.driverDao.get(obj);
	}

	public void edit(driverBean driverBean) throws Exception {
		this.driverDao.edit(driverBean);
		JSONObject obj = new JSONObject();
		obj.put("id", driverBean.getLogin());
		obj.put("updateType", "status");
		obj.put("status", driverBean.getState());
		loginUserService.update(obj);
	}

	public void editpassword(driverBean driverBean) throws Exception {
		this.driverDao.editpassword(driverBean);
		JSONObject obj = new JSONObject();
		obj.put("id", driverBean.getLogin());
		obj.put("updateType", "pwd");
		obj.put("pwd", "888888");
		loginUserService.update(obj);
	}
}
