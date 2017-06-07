package com.cms.mapper.wuliu;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.cms.model.wuliu.VaServiceBean;

public interface VaServiceMapper {
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
	
	//查询用户短信剩余次数
	
	public int getMsgSum(JSONObject obj);
	
	public List<VaServiceBean> getVaserviceList(JSONObject obj);
	
	public void updateVaservice(JSONObject obj);
	
	public void addUseHistory(JSONObject obj);
	
	//查询该套餐下得所有增值服务
	
	public List<VaServiceBean> getVaserviceListByPackageId(JSONObject obj);
}
