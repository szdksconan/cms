package com.cms.dao.xiaofei;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.xiaofei.CmsXReqRecMapper;
import com.cms.model.xiaofei.CmsXReqRec;
@Component
public class CmsXReqRecDaoImpl implements CmsXReqRecDao {
	
	@Autowired
	private CmsXReqRecMapper cmsXReqRecMapper;

	/**
	 * 添加用户发布的创新定制信息
	 */
	public void addUserReleaseAndInnovationCustomGetInfo(CmsXReqRec cmsXReqRec) {
		
		this.cmsXReqRecMapper.addUserReleaseAndInnovationCustomGetInfo(cmsXReqRec);
	}

	/**
	 * 查看全部创新定制信息
	 */
	public List<CmsXReqRec> selectAllCmsXReqRecGetInfo(String loclCode,String typeCode,Integer page,Integer pageSize) {
		// TODO Auto-generated method stub
		return this.cmsXReqRecMapper.selectAllCmsXReqRecGetInfo( loclCode, typeCode, page, pageSize);
	}

}
