package com.cms.elasticsearch.produce.index;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.elasticsearch.plugin.deletebyquery.DeleteByQueryPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

	private static Logger logger = LoggerFactory.getLogger(SpringConfiguration.class);
	@Bean
	public Client client(){
		logger.info("init elasticSearch SpringConfiguration......");
		InputStream in = SpringConfiguration.class.getClassLoader().getResourceAsStream("META-INF/spring/config.properties");
		String clusterName = null;
		String host = null;
		String port = null;
		Properties pps = new Properties();
		 try {
			pps.load(in);
			clusterName = pps.getProperty("elasticsearch.cluster.name").trim();
			host = pps.getProperty("elasticsearch.host").trim();
			port = pps.getProperty("elasticsearch.port","9300").trim();

			Settings settings = Settings.settingsBuilder()
					.put("client.transport.sniff",true)
					.put("cluster.name",clusterName)					 
					.build();
			
			Client client = TransportClient.builder()
					.settings(settings)
					.addPlugin(DeleteByQueryPlugin.class)
					.build()
					.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host),Integer.parseInt(port)));
			if (client!=null)
				return client;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.info("init elasticSearch SpringConfiguration error:META-INF/spring/config.properties FileNotFoundException");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("init elasticSearch SpringConfiguration error:{}:{} UnknownHostException",host,port);
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("init elasticSearch SpringConfiguration error:{} IOException,errorMessage:{}",host,e.getMessage());
		}finally{
			try {
				if (in!=null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public Client clientByNode(){		
		Node node = nodeBuilder().clusterName("cms-es").client(true).node();
		return node.client();
	}
	
}
