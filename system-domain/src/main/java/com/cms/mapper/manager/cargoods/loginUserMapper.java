package com.cms.mapper.manager.cargoods;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.loginUserBean;

public interface loginUserMapper {
	public loginUserBean getInfo(JSONObject obj);
	
	public void insert(loginUserBean bean);
	
	public void updateInfo(JSONObject obj);
	
	public JSONObject get(JSONObject obj);
	
	public void updateAudit(JSONObject obj);
	
	public void update(JSONObject obj)throws Exception;
	
	public void updateTel(JSONObject obj)throws Exception;
	
	public void updateLoginPwd(JSONObject obj)throws Exception;
	
	public void updatePayPwd(JSONObject obj)throws Exception;
}
