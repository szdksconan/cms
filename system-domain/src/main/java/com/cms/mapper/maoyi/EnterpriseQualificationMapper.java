package com.cms.mapper.maoyi;

import java.math.BigDecimal;
import java.util.List;

import com.cms.model.maoyi.EnterpriseQualification;
import com.cms.model.maoyi.TradeImage;

public interface EnterpriseQualificationMapper {
    void deleteQualif(Long id);

    void addQualif(EnterpriseQualification enterQualif);

    List<EnterpriseQualification> getAllQualif(Long id);

    void updateQualif(EnterpriseQualification enterQualif);
    
  //拿到对应id的资质信息
    public EnterpriseQualification getQulif(Long id);
    
}