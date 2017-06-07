package com.cms.iservice.shengchan;

import java.util.List;

import com.cms.model.shengchang.StorageTransportDemand;

public interface StorageService {
	/**
	 * 根据企业id获得所有的物流运输需求
	 * @param compid
	 * @return
	 */
	public List<StorageTransportDemand> getAllStorageTransportDemand(String compid);
	/**
	 * 根据对应的id获得对应得 物流需求
	 * @param id
	 * @return
	 */
	public StorageTransportDemand getStorageTransportDemandById(String id);
}
