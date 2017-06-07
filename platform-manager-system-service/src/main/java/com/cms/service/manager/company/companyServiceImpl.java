package com.cms.service.manager.company;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.company.companyService;
import com.cms.model.manager.companyBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.dao.manager.company.companyDao;
import com.cms.dao.manager.cargoods.loginUserDao;
import com.cms.iservice.manager.cargoods.loginUserService;
import com.cms.iservice.manager.cargoods.accountService;
import com.cms.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class companyServiceImpl implements companyService {
	@Autowired
	private companyDao companyDao;

	@Autowired
	private loginUserDao loginUserDao;

	@Autowired
	private loginUserService loginUserService;
	@Autowired
	private accountService accountService;

	public companyBean getInfo(JSONObject obj) {
		return this.companyDao.getInfo(obj);
	}

	public Grid dataGrid(companyBean companyBean, PageFilter ph) {
		JSONObject obj = (JSONObject) JSONObject.toJSON(companyBean);
		obj.put("order", ph.getOrderString());
		Grid grid = new Grid();
		grid.setRows(this.companyDao.dataGrid(obj));
		grid.setTotal(this.companyDao.dataGridCot(obj));
		return grid;
	}

	public void add(JSONObject obj)throws Exception {
//		obj.put("id", RSAUtils.encryptByPublicKey(obj.getString("companyId"), GlobalConstant.publicKey));
		obj.put("id",obj.getString("id"));
		if (this.loginUserDao.getInfo(obj)!=null){
			throw new Exception("账号已存在！");
		}
		this.loginUserService.insert(obj);//添加登录表
		this.accountService.insert(obj);//添加账号表
		obj.put("paperType", 1);
		this.companyDao.add(obj);
	}

	public void updateFlag(JSONObject obj)throws Exception {
		obj.put("updateType", "status");
		this.loginUserService.update(obj);
		this.companyDao.updateFlag(obj);
	}

	public companyBean get(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		return	this.companyDao.get(id);
	}


	public void update(JSONObject obj)throws Exception {
		this.companyDao.update(obj);
	}

	public void updatePwd(JSONObject obj) throws Exception {
		obj.put("updateType", "pwd");
		obj.put("pwd", MD5Util.md5("888888"));
		this.loginUserDao.update(obj);
	}

	public List<companyBean> dataGrid2(companyBean companyBean, PageFilter ph) {
		JSONObject obj = (JSONObject) JSONObject.toJSON(companyBean);
		obj.put("order", ph.getOrderString());
		return this.companyDao.dataGrid2(obj);
	}

	public void updateaudit(JSONObject obj) {
		this.companyDao.updateaudit(obj);
	}
}
