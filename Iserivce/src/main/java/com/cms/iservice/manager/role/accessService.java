package com.cms.iservice.manager.role;


import com.alibaba.fastjson.JSONObject;
import com.cms.model.manager.Tree;
import com.cms.model.manager.accessBean;
import com.cms.model.manager.dataRoleBean;
import com.cms.model.manager.roleBean;
import com.cms.model.util.Grid;
import com.cms.model.util.PageFilter;
import com.cms.model.util.SessionInfo;

import java.util.List;

public interface accessService {

	public List<accessBean> treeGrid();

	public void add(accessBean bean)throws Exception;

	public void delete(Long id)throws Exception;

	public void update(accessBean bean)throws Exception;

	public accessBean get(Long id);

	public List<Tree> tree(SessionInfo sessionInfo);

	public List<Tree> allTree(Boolean flag);

	public List<String> accessList(Long userId);
	
	public List<String> getAllAccessList();
	
	public dataRoleBean getInfo(dataRoleBean bean);
	
	public Grid dataGrid(dataRoleBean dataRoleBean, PageFilter ph);

	public void add(dataRoleBean dataRoleBean);

	public void deleteDataRole(Long id);

	public dataRoleBean getDataRole(Long id);
	
	public void update(dataRoleBean dataRoleBean);
	
	public void addGrant(dataRoleBean role)throws Exception;
	
	public Grid dataGridRole(JSONObject obj, PageFilter ph);
	
	public roleBean getRole(Long id);
	
	public void update(roleBean bean)throws Exception;
	
	public void add(roleBean bean)throws Exception;
	
	public void deleteRole(Long id)throws Exception;
	
	public void addGrant(roleBean role)throws Exception;
}
