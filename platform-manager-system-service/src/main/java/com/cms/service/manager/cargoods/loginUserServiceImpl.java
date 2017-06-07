package com.cms.service.manager.cargoods;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.cargoods.loginUserService;
import com.cms.model.manager.loginUserBean;
import com.cms.dao.manager.cargoods.loginUserDao;
import com.cms.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;

public class loginUserServiceImpl implements loginUserService {
	@Autowired
	private loginUserDao loginUserDao;

	public void insert(JSONObject obj) throws Exception {
		if (this.loginUserDao.getInfo(obj)!=null){
			throw new Exception("该手机号已经注册！");
		}
		loginUserBean login = new loginUserBean();
		login.setId(obj.getString("id"));
		login.setLoginPwd(MD5Util.md5("888888"));
		login.setCanConsume(0);//
		login.setUpateFlag(1);//不可修改
		login.setSysCreater(obj.getString("sessionId"));
		login.setStatus(22);
		this.loginUserDao.insert(login);
	}

	public void updateInfo(JSONObject obj) throws Exception {
		this.loginUserDao.updateInfo(obj);
	}

	public JSONObject get(JSONObject obj) {
		return this.loginUserDao.get(obj);
	}

	public void updateAudit(JSONObject obj) throws Exception {
		this.loginUserDao.updateAudit(obj);
	}

	public void updateTel(JSONObject obj) throws Exception {
		this.loginUserDao.updateTel(obj);
	}

	public void updateLoginPwd(JSONObject obj) throws Exception {
		if (!obj.getString("loginPwd").equals(MD5Util.md5(obj.getString("oldloginPwd")))){
			throw new Exception("老密码不正确！");
		}
		obj.put("loginPwd", MD5Util.md5(obj.getString("newloginPwd")));
		this.loginUserDao.updateLoginPwd(obj);
	}

	public void updatePayPwd(JSONObject obj) throws Exception {
		if (!obj.getString("payPwd").equals(MD5Util.md5(obj.getString("oldpayPwd")))){
			throw new Exception("老密码不正确！");
		}
		obj.put("payPwd", MD5Util.md5(obj.getString("newpayPwd")));
		this.loginUserDao.updatePayPwd(obj);
	}

	public void update(JSONObject obj) throws Exception {
		this.loginUserDao.update(obj);
	}
}
