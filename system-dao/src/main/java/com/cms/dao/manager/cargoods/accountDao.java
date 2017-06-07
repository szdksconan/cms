package com.cms.dao.manager.cargoods;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.accountBean;

public interface accountDao {
	public accountBean getInfo(JSONObject obj);
	
	public void insert(accountBean bean);
	
	public void update(accountBean bean);
}
