package com.cms.service.wuliu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.dao.wuliu.CarOnlineDao;
import com.cms.iservice.wuliu.CarOnlineService;
import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.MyCarBean;
import com.cms.service.common.redis.RedisUtil;





public class CarOnlineServiceImpl implements CarOnlineService {

	@Autowired
	private CarOnlineDao carOnlineDao;




	public List<MyCarBean> searchMap(Double lgr, Double lat, int round, int num) {

		// 计算出需要查询的坐标点范围
		Double degree = (24901 * 1609) / 360.0;
		double raidusMile = round;
		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		Double minLat = lat - radiusLat;
		Double maxLat = lat + radiusLat;
		Double mpdLng = Math.abs(degree * Math.cos(lat * (Math.PI / 180)));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		Double minLng = lgr - radiusLng;
		Double maxLng = lgr + radiusLng;

		JSONObject obj = new JSONObject();
		obj.put("minLng", minLng);
		obj.put("maxLng", maxLng);
		obj.put("minLat", minLat);
		obj.put("maxLat", maxLat);
		obj.put("num", num);

		return this.carOnlineDao.searchMap(obj);

	}


	public void changeFocus(Long id, Long login,String state) {
		JSONObject obj = new JSONObject();
		obj.put("car", id);
		obj.put("login", login);
		if("0".equals(state))
		this.carOnlineDao.changeFocus2(obj);
		else
		this.carOnlineDao.changeFocus(obj);
		
	}


	public List<MyCarBean> getMsgListByPh(String login, String createDate, String carNo, PageFilter ph) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("createDate", createDate);
		obj.put("order", ph.getOrderString());
		obj.put("carNo", carNo);
		return carOnlineDao.getMsgListByPh(obj);
	}


	public int getMsgListCount(String login, String createDate, String carNo) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("createDate", createDate);
		obj.put("carNo", carNo);
		return this.carOnlineDao.getMsgListCount(obj);
	}


	public void delMsg(Long id) {
		this.carOnlineDao.delMsg(id);
		
	}
	
	public List<MyCarBean> getListByPhMycar(String login,String carNo,PageFilter ph) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("order", ph.getOrderString());
		obj.put("carNo", carNo);
		List l = carOnlineDao.getListByPhMycar(obj);
		List list2 = new ArrayList<MyCarBean>();
		for(int i=0;i<l.size();i++){
			MyCarBean myCarBean = (MyCarBean) l.get(i);
			MyCarBean myCarBean2 = (MyCarBean) RedisUtil.get("chpp:mycar:"+myCarBean.getId());
			if(myCarBean2 != null){
				list2.add(myCarBean2) ;
				}
			else{
				list2.add(myCarBean);
			}
		}
		return list2;
	}
	public List<MyCarBean> getListByMapMycar(String login,String carNo,PageFilter ph) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("carNo", carNo);
		List l = carOnlineDao.getListByMapMycar(obj);
		List list2 = new ArrayList<MyCarBean>();
		for(int i=0;i<l.size();i++){
			MyCarBean myCarBean = (MyCarBean) l.get(i);
			MyCarBean myCarBean2 = (MyCarBean) RedisUtil.get("chpp:mycar:"+myCarBean.getId());
			if(myCarBean2 != null){
				list2.add(myCarBean2) ;
			}
			else{
				list2.add(myCarBean);
			}
		}
		return list2;
	}

	
	public int getListCountMycar(String login,String carNo) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("carNo", carNo);
		return this.carOnlineDao.getListCountMycar(obj);
	}


	public List<MyCarBean> getListByPhMyfocus(String login, String carNo, PageFilter ph) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("order", ph.getOrderString());
		obj.put("carNo", carNo);
		List l = carOnlineDao.getListByPhMyfocus(obj);
		List list2 = new ArrayList<MyCarBean>();
		for(int i=0;i<l.size();i++){
			MyCarBean myCarBean = (MyCarBean) l.get(i);
			MyCarBean myCarBean2 = (MyCarBean) RedisUtil.get("chpp:mycar:"+myCarBean.getId());
			if(myCarBean2 != null){
				list2.add(myCarBean2) ;
			}
			else{
				list2.add(myCarBean);
			}
		}
		return list2;
	}
	
	public List<MyCarBean> getListByMapMyfocus(String login, String carNo, PageFilter ph) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("carNo", carNo);
		List l = carOnlineDao.getListByMapMyfocus(obj);
		List list2 = new ArrayList<MyCarBean>();
		for(int i=0;i<l.size();i++){
			MyCarBean myCarBean = (MyCarBean) l.get(i);
			MyCarBean myCarBean2 = (MyCarBean) RedisUtil.get("chpp:mycar:"+myCarBean.getId());
			if(myCarBean2 != null){
				list2.add(myCarBean2) ;
			}
			else{
				list2.add(myCarBean);
			}
		}
		return list2;

	}


	public int getListCountMyfocus(String login, String carNo) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("carNo", carNo);
		return this.carOnlineDao.getListCountMyfocus(obj);
	}


	public List<MyCarBean> getListByPhAllcar(String login, String carNo, PageFilter ph, String city) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("order", ph.getOrderString());
		obj.put("carNo", carNo);
		obj.put("city", city);
		List l = carOnlineDao.getListByPhAllcar(obj);
		List list2 = new ArrayList<MyCarBean>();
		for(int i=0;i<l.size();i++){
			MyCarBean myCarBean = (MyCarBean) l.get(i);
			MyCarBean myCarBean2 = (MyCarBean) RedisUtil.get("chpp:mycar:"+myCarBean.getId());
			if(myCarBean2 != null){
				list2.add(myCarBean2) ;
			}
			else{
				list2.add(myCarBean);
			}
			
		}
		return list2;
	}


	public int getListCountAllcar(String login, String carNo, String city) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("carNo", carNo);
		obj.put("city", city);
		return this.carOnlineDao.getListCountAllcar(obj);
	}


	public void updateCarCondition(String id, String tag) {
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		obj.put("tag", tag);
		this.carOnlineDao.updateCarCondition(obj);
		
	}


	public void addMSg(String sendcarno, String sendtel, String msginfo, String login, Long id) {
	
		JSONObject obj = new JSONObject();
		obj.put("sendcarno", sendcarno);
		obj.put("sendtel", sendtel);
		obj.put("msginfo", msginfo);
		obj.put("login", login);
		obj.put("id", id);
		this.carOnlineDao.addMSg(obj);
		
	}


	public List<MyCarBean> getListByMapAllcar(String login, String carNo, String city) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("carNo", carNo);
		obj.put("city", city);
		List l = carOnlineDao.getListByMapAllcar(obj);
		List list2 = new ArrayList<MyCarBean>();
		for(int i=0;i<l.size();i++){
			MyCarBean myCarBean = (MyCarBean) l.get(i);
			MyCarBean myCarBean2 = (MyCarBean) RedisUtil.get("chpp:mycar:"+myCarBean.getId());
			if(myCarBean2 != null){
				list2.add(myCarBean2) ;
			}
			else{
				list2.add(myCarBean);
			}
		}
		return list2;
	}




}
