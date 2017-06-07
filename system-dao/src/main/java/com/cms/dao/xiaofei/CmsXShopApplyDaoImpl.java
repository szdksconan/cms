package com.cms.dao.xiaofei;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.xiaofei.CmsXShopApplyMapper;
import com.cms.model.xiaofei.CmsXShopApply;

@Component
public class CmsXShopApplyDaoImpl implements CmsXShopApplyDao {

	@Autowired
	private CmsXShopApplyMapper cmsXShopApplyMapper;
	
	/**
	 * 添加开店申请信息
	 */
	public void addOpenShopApplyAndBasicInfo(CmsXShopApply cmsXShopApply) {
		
		this.cmsXShopApplyMapper.addOpenShopApplyAndBasicInfo(cmsXShopApply);
	}

	/**
	 * 查询全部开店信息
	 */
	public List<CmsXShopApply> selectAllUserAndShopAndAttachmentGetInfo(String loclCode,String typeCode,Integer page,Integer pageSize) {
		// TODO Auto-generated method stub
		return this.cmsXShopApplyMapper.selectAllUserAndShopAndAttachmentGetInfo(loclCode,typeCode,page,pageSize);
	}

	public CmsXShopApply selectGetCmsXShopApplyByIdAndInfo(String Id) {
		// TODO Auto-generated method stub
		return this.cmsXShopApplyMapper.selectGetCmsXShopApplyByIdAndInfo(Id);
	}

}
