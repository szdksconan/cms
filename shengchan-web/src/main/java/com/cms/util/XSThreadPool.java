package com.cms.util;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class XSThreadPool extends ThreadPoolTaskExecutor {
    public XSThreadPool(){
        super();
        super.setMaxPoolSize(500);
        super.setCorePoolSize(5);
        super.setQueueCapacity(5000);
        super.setKeepAliveSeconds(10);
        super.initialize();
    }
}