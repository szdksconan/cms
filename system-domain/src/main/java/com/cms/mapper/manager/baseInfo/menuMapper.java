package com.cms.mapper.manager.baseInfo;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.menuBean;

public interface menuMapper {
	public List<menuBean> getAccessListForUser(JSONObject obj);
	
	public List<menuBean> getAllAccess(JSONObject obj);
	
	public List<String> accessList(String userId);
	
	public void delete(Long id);
	
	public menuBean getAccessById(Long id);
	
	public void update(menuBean bean);
	
	public void add(menuBean bean);
	
	public List<menuBean> userAccessGrid(String userId);
}
