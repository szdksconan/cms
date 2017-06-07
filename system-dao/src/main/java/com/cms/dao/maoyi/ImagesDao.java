package com.cms.dao.maoyi;

import java.util.List;

import com.cms.model.maoyi.CmsImages;


public interface ImagesDao{
	public int insert(List<CmsImages> lci);
	public List<CmsImages> getImagesByProductId(String productId) throws Exception;
}
