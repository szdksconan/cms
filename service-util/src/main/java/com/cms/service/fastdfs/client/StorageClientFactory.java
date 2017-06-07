package com.cms.service.fastdfs.client;

import java.io.IOException;

import com.cms.service.fastdfs.FastdfsClientConfig;

import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class StorageClientFactory implements KeyedPooledObjectFactory<String, StorageClient> {
	
	private Integer connectTimeout = FastdfsClientConfig.DEFAULT_CONNECT_TIMEOUT * 1000;
	private Integer networkTimeout = FastdfsClientConfig.DEFAULT_NETWORK_TIMEOUT * 1000;

	public StorageClientFactory() {
		super();
	}

	public StorageClientFactory(Integer connectTimeout, Integer networkTimeout) {
		super();
		this.connectTimeout = connectTimeout;
		this.networkTimeout = networkTimeout;
	}

	
	public PooledObject<StorageClient> makeObject(String key) {
		StorageClientImpl storageClient = new StorageClientImpl(key,connectTimeout,networkTimeout);
		PooledObject<StorageClient> pooledStorageClient = new DefaultPooledObject<StorageClient>(storageClient);
		return pooledStorageClient;
	}

	
	public void destroyObject(String key, PooledObject<StorageClient> pooledStorageClient) throws IOException {
		StorageClient storageClient = pooledStorageClient.getObject();
		storageClient.close();
	}

    
    public boolean validateObject(String key, PooledObject<StorageClient> p) {
        StorageClient storageClient  = p.getObject();
        if (storageClient.isClosed()) {
            //return false to ignore this closed client
            return false;
        } else {
            return true;
        }
    }

	
	public void activateObject(String key, PooledObject<StorageClient> p)
			throws Exception {
		
	}

	
	public void passivateObject(String key, PooledObject<StorageClient> p)
			throws Exception {
		
	}



}
