package com.cms.iservice.wuliu; 

import java.util.List;

import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.MyCarBean;
import com.cms.model.wuliu.MyCarBean;



public interface CarOnlineService {

	

	 
	 //根据条件锚点
	 
	 public List<MyCarBean> searchMap(Double lgr,Double lat,int round,int num);
	 
	 //添加或者删除关注记录
	 
	 public void changeFocus(Long id,Long login,String state);
	 
		//短信分页查询
	 public List<MyCarBean> getMsgListByPh(String login,String createDate,String carNo,PageFilter ph);
	 
	//短信查询总数
	 
	 public int getMsgListCount(String login,String createDate,String carNo);
	 
	 //删除短信记录
	 
	 public void delMsg(Long id);
	 
	 //我的车分页查询
		 public List<MyCarBean> getListByPhMycar(String login,String carNo,PageFilter ph);
		 
		 //获取map所需数据
		 public List<MyCarBean> getListByMapMycar(String login,String carNo,PageFilter ph);
		 
		//我的车查询总数
		 
		 public int getListCountMycar(String login,String carNo);
		 
		 
		 //我的关注车辆
		 public List<MyCarBean> getListByPhMyfocus(String login,String carNo,PageFilter ph);
		 
		 //获取Map所需数据
		 public List<MyCarBean> getListByMapMyfocus(String login,String carNo,PageFilter ph);
		 
		//我的关注车辆总数
		 
		 public int getListCountMyfocus(String login,String carNo);
		 
		 
		 //在线车库（不包含自有，关注）
		 public List<MyCarBean> getListByPhAllcar(String login,String carNo,PageFilter ph,String  city);
		 
		//在线车辆总数（不包含自有，关注）
		 
		 public int getListCountAllcar(String login,String carNo,String city);
		 
		 //更新车辆运行状态 id，tag(0待装 1在途)
		 public void updateCarCondition(String id,String tag);
		 
		 //增加短信记录
		 public void addMSg(String sendcarno,String sendtel,String msginfo,String login,Long id);
		 
		 public List<MyCarBean> getListByMapAllcar(String login,String carNo,String  city);
}
