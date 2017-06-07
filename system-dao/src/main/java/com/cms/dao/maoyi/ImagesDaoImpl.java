/**
 * @Title: ProductDAOImpl.java
 * @Copyright (C) 2016 产贸送网络
 * @Description:
 * @Revision History:
 * @Revision 1.0 2016年5月4日  余波
 */

package com.cms.dao.maoyi;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cms.mapper.maoyi.ImagesMapper;
import com.cms.model.maoyi.CmsImages;

@Component
public class ImagesDaoImpl implements ImagesDao {
	@Autowired
	private ImagesMapper imagesMapper;

	public int insert(List<CmsImages> lci) {
		// TODO Auto-generated method stub
		HashMap<String, List<CmsImages>> map = new HashMap<String, List<CmsImages>>();
		map.put("list", lci);
		return imagesMapper.insert(map);
	}

	public List<CmsImages> getImagesByProductId(String productId) throws Exception {
		// TODO Auto-generated method stub
		return imagesMapper.getImagesByProductId(productId);
	}

	
	

}
