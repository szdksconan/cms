package com.cms.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManagerProvider {
	public static void main(String[] args) throws IOException {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
		context.start();
		System.out.println("servive have started........");
		System.in.read();
		// com.alibaba.dubbo.container.Main.main(args);
	}		
}
