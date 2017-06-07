package com.cms.iservice.wuliu;

import java.util.List;

import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.MyCarBean;



public interface MyCarService {
	//我的车库分页查询
 public List<MyCarBean> getMyCarListByPh(String login,String city,String carNo,PageFilter ph);
 
 //我的车库总条数查询
 
 public int getMyCarListCount(String login,String city,String carNo);
 
 //向我的车库添加车辆
 
 public void addCarAndRelative(MyCarBean myCarBean,String login,String company);
 
 //查询货车基础属性字典表
 
 public List<MyCarBean> getCarDic(Long pid);
 
 //查询车辆信息是否登记
 
	public int getCarCount(String login ,String carNo);
	
//删除车辆相关信息
	
	public void delCarAndRelative(String id,String carId);
	
	public MyCarBean getId(String id);
}
