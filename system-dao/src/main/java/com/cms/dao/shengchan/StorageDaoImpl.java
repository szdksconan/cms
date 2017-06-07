package com.cms.dao.shengchan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cms.mapper.shengchan.StorageTransportDemandMapper;
import com.cms.model.shengchang.StorageTransportDemand;
@Repository
public class StorageDaoImpl implements StorageDao {
	@Autowired
	private StorageTransportDemandMapper storageTransportDemandMapper;
	public List<StorageTransportDemand> getAllStorageTransportDemand(String compid) {
		// TODO Auto-generated method stub
		return storageTransportDemandMapper.getAllStorageTransportDemand(compid);
	}

	public StorageTransportDemand getStorageTransportDemandById(String id) {
		// TODO Auto-generated method stub
		return storageTransportDemandMapper.selectByPrimaryKey(Long.parseLong(id));
	}

}
