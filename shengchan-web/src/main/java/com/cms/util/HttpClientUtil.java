package com.cms.util;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 * Created by liuxin on 2016/5/17.
 */
public class HttpClientUtil {
    /**
     * 封装转换参数
     * @param url
     * @param params
     * @return
     */
    private static HttpPost postForm(String url, Map params){
        HttpPost httpost = new HttpPost(url);
        try {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            Set<String> keySet = params.keySet();
            for(String key : keySet) {
                nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpost;
    }

    /**
     * post提交
     * @param url http url
     * @param map 参数
     * @param headerMap http header 头信息
     * @return
     */
    public static String Post(String url,Map map,Map headerMap){
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost post = postForm(url, map);
        if (headerMap!=null){
            Set<String> headerSet = headerMap.keySet();
            for(String key : headerSet) {
                post.setHeader(key,headerMap.get(key).toString());
            }
        }
        HttpResponse response = null;
        String body = "";
        try {
            response = httpClient.execute(post);
            body = EntityUtils.toString(response.getEntity());
            httpClient.getConnectionManager().shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }
}
