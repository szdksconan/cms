package com.cms.dao.wuliu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.cms.mapper.wuliu.VaServiceMapper;
import com.cms.model.wuliu.VaServiceBean;

@Component
public class VaServiceDaoImp implements VaServiceDao {
	@Autowired
	private VaServiceMapper vaServiceMapper;

	public List<VaServiceBean> getUserVaService(JSONObject obj) {
		return this.vaServiceMapper.getUserVaService(obj);
	}

	public List<VaServiceBean> getAllUserVaService() {
		return this.vaServiceMapper.getAllUserVaService();
	}

	public void add(JSONObject obj) {
		List<VaServiceBean> list = this.vaServiceMapper.getVaserviceListByPackageId(obj);
		//循环插入
		for(VaServiceBean vaServiceBean : list){
			JSONObject obj2 =  new JSONObject();
			obj2.put("subscriberID", vaServiceBean.getSubscriberID());
			obj2.put("vaServiceID", vaServiceBean.getVaServiceID());
			obj2.put("purchaseDate", vaServiceBean.getPurchaseDate2());
			obj2.put("username", vaServiceBean.getUsername());
			obj2.put("serviceperiodstart", vaServiceBean.getServiceperiodstart2());
			obj2.put("serviceperiodend", vaServiceBean.getServiceperiodend2());
			obj2.put("remainAmount", vaServiceBean.getMeasureAmount());
			this.vaServiceMapper.add(obj2);
		}
		
	}

	public List<VaServiceBean> getInfo(JSONObject obj) {
		return this.vaServiceMapper.getInfo(obj);
	}

	public List<VaServiceBean> getUserHisVaService(JSONObject obj) {
		return this.vaServiceMapper.getUserHisVaService(obj);
	}

	public List<VaServiceBean> getInfo2(JSONObject obj) {
		return this.vaServiceMapper.getInfo2(obj);
	}

	public VaServiceBean getInfo3(JSONObject obj) {
		return this.vaServiceMapper.getInfo3(obj);
	}

	public int getMsgSum(JSONObject obj) {
		return this.vaServiceMapper.getMsgSum(obj);
	}

	public List<VaServiceBean> getVaserviceList(JSONObject obj) {
		return this.vaServiceMapper.getVaserviceList(obj);
	}

	public void updateVaservice(JSONObject obj) {
		this.vaServiceMapper.updateVaservice(obj);
		
	}
	
	public void addUseHistory(JSONObject obj){
		this.vaServiceMapper.addUseHistory(obj);
	}

}
