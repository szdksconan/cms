package com.cms.storage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cms.dao.shengchan.StorageDao;
import com.cms.iservice.shengchan.StorageService;
import com.cms.model.shengchang.StorageTransportDemand;

public class StorageServiceImpl implements StorageService{
	@Autowired
	private StorageDao storageDao;
	public List<StorageTransportDemand> getAllStorageTransportDemand(String compid) {
		// TODO Auto-generated method stub
		return storageDao.getAllStorageTransportDemand(compid);
	}

	public StorageTransportDemand getStorageTransportDemandById(String id) {
		// TODO Auto-generated method stub
		return storageDao.getStorageTransportDemandById(id);
	}

}
