package com.cms.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 加载properties文件
 * Created by liuxin on 2016/5/18.
 */
public class HttpPropertyConfigurer extends PropertyPlaceholderConfigurer {
    private static Map<String, Object> ctxPropertiesMap;

    protected void processProperties(ConfigurableListableBeanFactory beanFactory,Properties props)throws BeansException {
        super.processProperties(beanFactory, props);
        ctxPropertiesMap = new HashMap<String, Object>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    public static Object getContextProperty(String name) {
        return ctxPropertiesMap.get(name);
    }
}
