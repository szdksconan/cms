package com.cms.service.fastdfs.client;

import java.io.IOException;
import java.util.List;

import com.cms.service.fastdfs.data.GroupInfo;
import com.cms.service.fastdfs.data.Result;
import com.cms.service.fastdfs.data.StorageInfo;
import com.cms.service.fastdfs.data.UploadStorage;

public interface TrackerClient {

	public Result<UploadStorage> getUploadStorage() throws IOException;
	public Result<String> getUpdateStorageAddr(String group,String fileName) throws IOException;
	public Result<String> getDownloadStorageAddr(String group,String fileName) throws IOException;
	public Result<List<GroupInfo>> getGroupInfos() throws IOException;
	public Result<List<StorageInfo>> getStorageInfos(String group) throws IOException;
	public void close() throws IOException;
	
}
