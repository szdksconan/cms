package com.cms.service.manager.cargoods;

import com.alibaba.fastjson.JSONObject;
import com.cms.iservice.manager.cargoods.accountService;
import com.cms.model.manager.accountBean;
import com.cms.dao.manager.cargoods.accountDao;
import org.springframework.beans.factory.annotation.Autowired;

public class accountServiceImpl implements accountService {
	@Autowired
	private accountDao accountDao;

	public void insert(JSONObject obj) throws Exception {
		if (this.accountDao.getInfo(obj)!=null){
			throw new Exception("该手机号已经注册！");
		}
		accountBean bean = new accountBean();
		bean.setId(obj.getString("id"));
		bean.setAccountType(obj.getIntValue("accountType"));
		accountDao.insert(bean);
	}

}
