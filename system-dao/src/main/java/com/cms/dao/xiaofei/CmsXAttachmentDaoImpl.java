package com.cms.dao.xiaofei;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.xiaofei.CmsXAttachmentMapper;
import com.cms.model.xiaofei.CmsXAttachment;

@Component
public class CmsXAttachmentDaoImpl implements CmsXAttachmentDao {
	
	@Autowired
	private CmsXAttachmentMapper cmsXAttachmentMapper;

	/**
	 * 附件信息
	 */
	public void addShopApplyAndUploadGetAttachmentInfo(CmsXAttachment cmsXShopApplyAttachment) {
		
		this.cmsXAttachmentMapper.addShopApplyAndUploadGetAttachmentInfo(cmsXShopApplyAttachment);
	}

	public CmsXAttachment selectGetCodeAndAttachment(String code) {
		// TODO Auto-generated method stub
		return this.cmsXAttachmentMapper.selectGetCodeAndAttachment(code);
	}

	public List<CmsXAttachment> selectGetByIdAndmentInfo(String Id) {
		// TODO Auto-generated method stub
		return this.cmsXAttachmentMapper.selectGetByIdAndmentInfo(Id);
	}


}
