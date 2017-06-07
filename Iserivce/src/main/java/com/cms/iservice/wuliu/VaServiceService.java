package com.cms.iservice.wuliu;

import java.util.List;
import com.cms.model.util.PageFilter;
import com.cms.model.wuliu.VaServiceBean;

public interface VaServiceService {
	//查询已购服务
		public List<VaServiceBean> getUserVaService(Long loginusert);
		//查询所有增值服务
		public List<VaServiceBean> getAllUserVaService();
		//购买服务
		public void add(Long id,Long loginuser);
		//查询需购买服务详细信息
		public VaServiceBean getInfo(Long id);
		//查询已购服务历史
		public List<VaServiceBean> getUserHisVaService(Long loginusert,String createDate,String comboName,PageFilter ph);
		
		public List<VaServiceBean> getUserHisVaService2(Long loginusert,String createDate,String comboName);
		//查询需要购买的服务详细信息2
		public VaServiceBean getInfo2(Long id);
		
		//查询用户剩余短信量
		
		public int getMsgSum(String login,String type);
		
		//扣除短信条数
		
		public void updateMsgSum(String login,String type,Integer count);
		
		

}
