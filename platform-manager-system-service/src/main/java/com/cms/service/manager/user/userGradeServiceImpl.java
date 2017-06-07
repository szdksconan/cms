package com.cms.service.manager.user;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.user.userGradeService;
import com.cms.model.manager.userBean;
import com.cms.model.manager.userGradeBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;
import com.cms.util.MD5Util;
import com.cms.dao.manager.user.userDao;
import com.cms.dao.manager.user.userGradeDao;
import org.springframework.beans.factory.annotation.Autowired;

public class userGradeServiceImpl implements userGradeService {
	@Autowired
	private userGradeDao userGradeDao;
	
	@Autowired
	private userDao userDao;

	public Grid dataGrid(PageFilter ph) {
		JSONObject obj = new JSONObject();
		obj.put("order", ph.getOrderString());
		Grid grid = new Grid();
		grid.setRows(this.userGradeDao.dataGrid(obj));
		grid.setTotal(this.userGradeDao.dataGridCot(obj));
		return grid;
	}

	public void add(userGradeBean bean) throws Exception {
		this.userGradeDao.add(bean);
	}

	public void edit(userGradeBean bean) throws Exception {
		this.userGradeDao.edit(bean);
	}

	public void delete(Long id) throws Exception {
		this.userGradeDao.delete(id);
	}

	public userGradeBean get(Long id) {
		return this.userGradeDao.get(id);
	}
	


	public userBean getUserInfo(userBean bean) {
		return this.userDao.getUserInfo(bean);
	}

	public Grid dataGrid(userBean userBean, PageFilter ph) {
		JSONObject obj = (JSONObject) JSONObject.toJSON(userBean);
		obj.put("order", ph.getOrderString());
		Grid grid = new Grid();
		grid.setRows(this.userDao.dataGrid(obj));
		grid.setTotal(this.userDao.dataGridCot(obj));
		return grid;
	}

	public void add(userBean userBean) throws Exception {
		if (this.userDao.getUserInfo(userBean)!=null){
			throw new Exception("登录名已被占用，请重新输入！");
		}
		userBean.setLoginPwd(MD5Util.md5(userBean.getLoginPwd()));
		this.userDao.add(userBean);

	}

	public void deleteuser(Long id)throws Exception {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		this.userDao.delete(obj);
	}

	public userBean getuser(Long id) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		return	this.userDao.get(id);
	}

	public void update(userBean userBean)throws Exception {
		if (userBean.getOldPwd().substring(0, 6).equals(userBean.getLoginPwd())){
			userBean.setLoginPwd(userBean.getOldPwd());
		}else {
			userBean.setLoginPwd(MD5Util.md5(userBean.getLoginPwd()));
		}
		this.userDao.update(userBean);
	}

	public void editUserPwd(SessionInfo sessionInfo, String oldPwd, String pwd) throws Exception {
		userBean bean = new userBean();
		bean.setLoginName(sessionInfo.getLoginName());
		userBean user = this.userDao.getUserInfo(bean);
		if (!MD5Util.md5(oldPwd).equals(user.getLoginPwd())){
			throw new Exception("密码修改失败，原密码输入错误！");
		}
		user.setLoginPwd(MD5Util.md5(pwd));
		this.userDao.update(user);
	}

}
