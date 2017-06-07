package com.cms.service.wuliu;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cms.dao.wuliu.MyCarDao;
import com.cms.iservice.common.GlobalIdService;
import com.cms.iservice.wuliu.InfoPublishService;
import com.cms.iservice.wuliu.MyCarService;
import com.cms.model.manager.carDicBean;
import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.MyCarBean;
import com.cms.service.common.redis.RedisUtil;



public class MyCarServiceImpl implements MyCarService{
	
	@Autowired
	private MyCarDao myCarDao;
	
	@Autowired
	private GlobalIdService globalIdService;
	
	@Autowired
	private InfoPublishService infoPublishService;
	
	

	public List<MyCarBean> getMyCarListByPh(String login, String city, String carNo, PageFilter ph) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("city", city);
		obj.put("order", ph.getOrderString());
		obj.put("carNo", carNo);
		return myCarDao.getMyCarListByPh(obj);
	}


	public int getMyCarListCount(String login, String city, String carNo) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("city", city);
		obj.put("carNo", carNo);
		return this.myCarDao.getMyCarListCount(obj);
	}


	public void addCarAndRelative(MyCarBean myCarBean, String login,String company) {
		//获取车型中文名
		carDicBean carDicBean = this.myCarDao.getDicById(myCarBean.getCarType());
		carDicBean carDicBean2 =this.myCarDao.getDicById(myCarBean.getCarTrafficType());
		carDicBean carDicBean3 =this.myCarDao.getDicById(myCarBean.getCarAxle());
		carDicBean carDicBean4 =this.myCarDao.getDicById(myCarBean.getCarContainer());
		Map m = getMapRandom();
		myCarBean.setCarTypeName(carDicBean.getName());
		myCarBean.setCarTrafficTypeName(carDicBean2.getName());
		myCarBean.setCarAxleName(carDicBean3.getName());
		myCarBean.setCarContainerName(carDicBean4.getName());
		myCarBean.setCarLocationTag("1");
		myCarBean.setCarLongitude(Double.valueOf(m.get("longitude").toString()) );
		myCarBean.setCarLatitude(Double.valueOf(m.get("latitude").toString()) );
		myCarBean.setCarAddress("1");
		myCarBean.setCarCondition("");
		int count = this.myCarDao.addCar(myCarBean);
		Long id = Long.valueOf(myCarBean.getId()) ;
		RedisUtil.set("chpp:mycar:"+myCarBean.getId(), myCarBean);
		//System.out.println("========>存进redis的key是"+myCarBean.getId());
	//	MyCarBean myCarBean2 = (MyCarBean) RedisUtil.get(myCarBean.getId());
		//System.out.println("========>从redis中取出的carNo是"+myCarBean2.getCarNo());
		JSONObject obj = new JSONObject();
		Long mid = globalIdService.getGlobalId();
	//	obj.put("id", null);
		obj.put("id", mid);
		obj.put("car", id);
		obj.put("login", login);
		obj.put("company", company);
		this.myCarDao.addRelative(obj);
		JSONObject json = new JSONObject();
        json.put("infoType", 2);
        json.put("beginProvinceId", myCarBean.getBeginProvinceId2());
        json.put("beginAreaId", myCarBean.getBeginAreaId2());
		json.put("beginCityId", myCarBean.getBeginCityId2());
		json.put("endProvinceId", myCarBean.getEndProvinceId2());
		json.put("endAreaId", myCarBean.getEndAreaId2());
		json.put("endCityId", myCarBean.getEndCityId2());
		json.put("beginProvinceName", myCarBean.getBeginProvinceName2());
		json.put("beginAreaName", myCarBean.getBeginAreaName2());
		json.put("beginCityName", myCarBean.getBeginCityName2());
		json.put("endProvinceName", myCarBean.getEndProvinceName2());
		json.put("endAreaName", myCarBean.getEndAreaName2());
		json.put("endCityName", myCarBean.getEndCityName2());
		json.put("provinceAreaId", myCarBean.getProvinceAreaId2());
		json.put("mainTag",1);
		json.put("carId",id);
		json.put("userId",login);
		try {
			this.infoPublishService.saveAddress(json);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	//	throw new RuntimeException("抛出异常");
		}


	public List<MyCarBean> getCarDic(Long pid) {
		
		return this.myCarDao.getCarDic(pid);
	}


	public int getCarCount(String login, String carNo) {
		JSONObject obj = new JSONObject();
		obj.put("login", login);
		obj.put("carNo", carNo);
		return this.myCarDao.getCarCount(obj);
	}


	public void delCarAndRelative(String id, String carId) {
		
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		obj.put("carId", carId);
		this.myCarDao.delCarAndRelative(obj);
		this.myCarDao.delCar(obj);
		RedisUtil.del("chpp:mycar:"+carId);
	}

	public MyCarBean getId(String id){
		JSONObject obj = new JSONObject();
		obj.put("id", id);
		return this.myCarDao.getId(obj);
	}
	
	
	/**
	 * 随机获取坐标值和所在城市
	 */
	public static  Map getMapRandom(){
		DecimalFormat dcmFmt = new DecimalFormat("0.000000");
		Random rand = new Random();
		Double longitude =  79.446974 + ((116.388746 - 79.446974) * new Random().nextDouble());
		Double latitude = 23.776595 + ((41.126067 - 23.776595) * new Random().nextDouble());
		Map map = new HashMap();
		map.put("longitude",dcmFmt.format(longitude));
		map.put("latitude",dcmFmt.format(latitude));
		return map;
	}

	
}
