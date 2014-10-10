package com.chf.sample.spring.integration.http;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

public class HttpClient {

	private static Logger logger = Logger.getLogger(HttpClient.class);

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"http-outbound-config.xml");

		MessageChannel inputChannel = context.getBean("inputChannel",
				MessageChannel.class);
		PollableChannel outputChannel = context.getBean("outputChannel",
				PollableChannel.class);
		inputChannel.send(new GenericMessage<String>("World1"));
		inputChannel.send(new GenericMessage<String>("World2"));

		logger.info("==> HelloWorldDemo: "
				+ outputChannel.receive(0).getPayload());
		logger.info("==> HelloWorldDemo: "
				+ outputChannel.receive(0).getPayload());

		// ((ClassPathXmlApplicationContext) context).close();
	}
}
