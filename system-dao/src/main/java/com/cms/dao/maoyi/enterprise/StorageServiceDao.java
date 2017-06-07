package com.cms.dao.maoyi.enterprise;

import java.util.List;

import com.cms.model.maoyi.StorageService;

public interface StorageServiceDao {
	//拿到所有的仓库信息
		public List<StorageService> getAllStorage(Long id);
		
		//新增某一个仓库
		public void addStorage(StorageService storageService);
		
		 //删除对应企业id的所有仓库信息
		public void deleteAllStorage(Long id);
		
	    //删除某一个仓库信息
		public void deleteStorage(Long id);
		
		//修改某一个仓库
	    public void updateStorage(StorageService storageService);
	    
	    //拿到某一个仓库信息	
	    public StorageService getStorage(Long id);
}
