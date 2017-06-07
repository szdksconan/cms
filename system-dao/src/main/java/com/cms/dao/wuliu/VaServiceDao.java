package com.cms.dao.wuliu;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.VaServiceBean;

public interface VaServiceDao {
	//查询已购服务
	public List<VaServiceBean> getUserVaService(JSONObject obj);
	//查询所有增值服务
	public List<VaServiceBean> getAllUserVaService();
	//购买服务
	public void add(JSONObject obj);
	//查询需购买服务详细信息
	public  List<VaServiceBean> getInfo(JSONObject obj);
	
	//查询已购服务
	public List<VaServiceBean> getUserHisVaService(JSONObject obj);
	//查询需购买服务详细信息
	public  List<VaServiceBean> getInfo2(JSONObject obj);
	
	public VaServiceBean getInfo3(JSONObject obj);
	
	public int getMsgSum(JSONObject obj);
	
	public List<VaServiceBean> getVaserviceList(JSONObject obj);
	
	public void updateVaservice(JSONObject obj);
	
	public void addUseHistory(JSONObject obj);
}
