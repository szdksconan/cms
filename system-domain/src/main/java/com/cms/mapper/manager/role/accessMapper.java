package com.cms.mapper.manager.role;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.accessBean;

public interface accessMapper {
	public List<accessBean> getAccessListForUser(JSONObject obj);
	
	public List<accessBean> getAllAccess(JSONObject obj);
	
	public List<String> accessList(Long userId);
	
	public void delete(Long id);
	
	public accessBean getAccessById(Long id);
	
	public void update(accessBean bean);
	
	public void add(accessBean bean);
	
	public List<accessBean> userAccessGrid(Long userId);
}
