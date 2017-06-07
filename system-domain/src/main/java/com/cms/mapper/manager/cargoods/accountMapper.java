package com.cms.mapper.manager.cargoods;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.accountBean;

public interface accountMapper {
	public accountBean getInfo(JSONObject obj);
	
	public void insert(accountBean bean);
	
	public void update(accountBean bean);
}
