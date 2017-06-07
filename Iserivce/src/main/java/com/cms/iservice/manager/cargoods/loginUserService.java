package com.cms.iservice.manager.cargoods;

import com.alibaba.fastjson.JSONObject;

public interface loginUserService {
	public void insert(JSONObject obj)throws Exception;
	
	public void updateInfo(JSONObject obj)throws Exception;
	
	public void updateTel(JSONObject obj)throws Exception;
	
	public void updateLoginPwd(JSONObject obj)throws Exception;
	
	public void updatePayPwd(JSONObject obj)throws Exception;
	
	public void update(JSONObject obj)throws Exception;
	
	public JSONObject get(JSONObject obj);
	
	public void updateAudit(JSONObject obj)throws Exception;
	
}
