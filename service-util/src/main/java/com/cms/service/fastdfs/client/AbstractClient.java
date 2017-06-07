package com.cms.service.fastdfs.client;

import com.cms.service.fastdfs.command.AbstractCmd;

/**
 * 提供一些公用的的方法
 * Created by weibo on 2016/1/5
 */
public abstract class AbstractClient {

    protected String[] splitFileId(String fileid) {
        return AbstractCmd.splitFileId(fileid);
    }
}
