package com.cms.dao.maoyi.enterprise.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.dao.maoyi.enterprise.StorageServiceDao;
import com.cms.mapper.maoyi.StorageServiceMapper;
import com.cms.model.maoyi.StorageService;

@Repository
public class StorageServiceDaoImpl implements StorageServiceDao {

	@Autowired
	private StorageServiceMapper   storageServiceMapper;
	
	public List<StorageService> getAllStorage(Long id) {
		return storageServiceMapper.getAllStorage(id);
	}

	public void addStorage(StorageService storageService) {
       storageServiceMapper.addStorage(storageService);
	}

	//删除对应企业id的所有仓库信息
	public void deleteAllStorage(Long id) {
		storageServiceMapper.deleteAllStorage(id);
	}
	 //删除某一个仓库信息
	public void deleteStorage(Long id) {
		storageServiceMapper.deleteStorage(id);
	}
	//修改某一个仓库
	public void updateStorage(StorageService storageService) {
		storageServiceMapper.updateStorage(storageService);
	}
    //拿到某一个仓库信息	
	public StorageService getStorage(Long id) {
        return storageServiceMapper.getStorage(id);		
	}

}
