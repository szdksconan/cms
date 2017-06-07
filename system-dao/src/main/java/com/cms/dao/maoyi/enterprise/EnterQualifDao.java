package com.cms.dao.maoyi.enterprise;

import java.util.List;

import com.cms.model.maoyi.EnterpriseQualification;
import com.cms.model.maoyi.TradeImage;

public interface EnterQualifDao {

	     public void deleteQualif(Long id);

	   public void addQualif(EnterpriseQualification enterQualif);

       public  List<EnterpriseQualification> getAllQualif(Long id);

	   public void updateQualif(EnterpriseQualification enterQualif);
	  //拿到对应id的资质信息
	   public EnterpriseQualification getQualif(Long id);
	   
}
