package com.cms.service.wuliu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.dao.wuliu.VaServiceDao;
import com.cms.iservice.wuliu.VaServiceService;
import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.VaServiceBean;

public class VaServiceServiceImpl implements VaServiceService{

	@Autowired
	private VaServiceDao vaServiceDao;
	
	
	public List<VaServiceBean> getUserVaService(Long loginusert) {
		JSONObject obj = new JSONObject();
		obj.put("loginusert", loginusert);
		return vaServiceDao.getUserVaService(obj);
	}

	
	public List<VaServiceBean> getAllUserVaService() {
		return vaServiceDao.getAllUserVaService();
	}

	
	public void add(Long id,Long loginuser) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		obj.put("loginuser",loginuser);
		this.vaServiceDao.add(obj);
	}

	
	public VaServiceBean getInfo(Long id) {
		VaServiceBean returnva = new VaServiceBean();
		JSONObject obj = new JSONObject();
		obj.put("id", id);

		StringBuffer note = new StringBuffer();
		List l = this.vaServiceDao.getInfo(obj);
	
		for(int i=0;i<l.size();i++){
			VaServiceBean va = (VaServiceBean) l.get(i);
			note.append(va.getVaServiceName());
			note.append(":");
			note.append(va.getMeasureAmount());
			note.append(va.getMeasurementUnit());
			note.append(";");
		}
		returnva.setNote(note.toString());
		return returnva;
	}

	
	public List<VaServiceBean> getUserHisVaService(Long loginusert,String createDate,String comboName,PageFilter ph) {
		JSONObject obj = new JSONObject();
		obj.put("loginusert", loginusert);
		obj.put("order", ph.getOrderString());
		obj.put("createDate", createDate);
		obj.put("comboName", comboName);
		return vaServiceDao.getUserHisVaService(obj);
	}
	
	
	public List<VaServiceBean> getUserHisVaService2(Long loginusert,String createDate,String comboName) {
		JSONObject obj = new JSONObject();
		obj.put("loginusert", loginusert);
		obj.put("createDate", createDate);
		obj.put("comboName", comboName);
		return vaServiceDao.getUserHisVaService(obj);
	}
	
	public VaServiceBean getInfo2(Long id) {
		VaServiceBean returnva = new VaServiceBean();
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		//查出套餐
		VaServiceBean servicepackage =  this.vaServiceDao.getInfo3(obj);
		StringBuffer note = new StringBuffer();
		//查出包含服务
		List l = this.vaServiceDao.getInfo2(obj);
	
		for(int i=0;i<l.size();i++){
			VaServiceBean va = (VaServiceBean) l.get(i);
			note.append(va.getVaServiceName());
			note.append(":");
			note.append(va.getMeasureAmount());
			note.append(va.getMeasurementUnit());
			note.append(";");
			returnva.setMeasurePeriod(va.getMeasurePeriod()+"月");
		}
		returnva.setId(servicepackage.getId());
		returnva.setPrice(servicepackage.getPrice());
		returnva.setServicepackagename(servicepackage.getServicepackagename());
		returnva.setSalestag(servicepackage.getSalestag());
		
		returnva.setNote(note.toString());
		return returnva;
	}


	public int getMsgSum(String login, String type) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("type", type);
		return this.vaServiceDao.getMsgSum(obj);
	}


	public void updateMsgSum(String login, String type, Integer count) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("type", type);
		//取出剩余次数不为0且没有过期的套餐
		List list = this.vaServiceDao.getVaserviceList(obj);
		//求得用户剩余总数
		int sum = this.vaServiceDao.getMsgSum(obj);
		//消费总数大于或等于剩余总数时
		if(count >= sum){
			//轮询订购记录且将最后一条置为负数
			for(int i=0;i<list.size();i++){
				VaServiceBean bean = (VaServiceBean) list.get(i);
				JSONObject singleobj = new JSONObject();
				singleobj.put("id", bean.getId());
				if(i == (list.size()-1)){
					singleobj.put("sum", sum-count);
					this.vaServiceDao.updateVaservice(singleobj);
				}
				else{
					singleobj.put("sum", 0);
					this.vaServiceDao.updateVaservice(singleobj);
				}
				
			}
		}
		else{
			//轮询订购记录
			for(int i=0;i<list.size();i++){
				VaServiceBean bean = (VaServiceBean) list.get(i);
				JSONObject singleobj2 = new JSONObject();
				singleobj2.put("id", bean.getId());
				int singlesum = Integer.valueOf(bean.getRemainAmount());
				if(count > 0){
				if(singlesum < count){
					singleobj2.put("sum", 0);
					this.vaServiceDao.updateVaservice(singleobj2);
					count = count - singlesum;
				}else{
					singleobj2.put("sum", singlesum-count);
					this.vaServiceDao.updateVaservice(singleobj2);
			
					count = 0;
				}
				}
				else
					break;
			}
		}
	
	}
	
}
