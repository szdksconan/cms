package com.cms.dao.shengchan;

import java.util.List;

import com.cms.model.shengchang.StorageTransportDemand;

public interface StorageDao {
	
	public List<StorageTransportDemand> getAllStorageTransportDemand(String compid);
	
	public StorageTransportDemand getStorageTransportDemandById(String id);
}
