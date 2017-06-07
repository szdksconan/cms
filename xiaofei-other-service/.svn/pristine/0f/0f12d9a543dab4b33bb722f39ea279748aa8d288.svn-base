package com.cms.service.xiaofei.openShop;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.xiaofei.CmsXAttachmentDao;
import com.cms.iservice.xiaofei.CmsXAttachmentService;
import com.cms.model.xiaofei.CmsXAttachment;

public class CmsXAttachmentServiceImpl implements CmsXAttachmentService {

	@Autowired
	private CmsXAttachmentDao cmsXAttachmentDao;
	
	/**
	 * 附件信息
	 */
	public void addShopApplyAndUploadGetAttachmentInfo(CmsXAttachment cmsXShopApplyAttachment) {
		
		this.cmsXAttachmentDao.addShopApplyAndUploadGetAttachmentInfo(cmsXShopApplyAttachment);
	}

}
