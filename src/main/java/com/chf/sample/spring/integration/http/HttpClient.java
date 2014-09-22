package com.chf.sample.spring.integration.http;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HttpClient {

	private static Logger logger = Logger.getLogger(HttpClient.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"http-outbound-config.xml");
		RequestGateway requestGateway = context.getBean("requestGateway",
				RequestGateway.class);
		String reply = requestGateway.echo("Hello");
		logger.info("~~~~~~" + reply);
	}
}
