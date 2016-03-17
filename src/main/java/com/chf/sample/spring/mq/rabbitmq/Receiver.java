package com.chf.sample.spring.mq.rabbitmq;

public class Receiver {

	public void receiveMessage(String message) {
		System.out.println("Received <" + message + ">");
	}

}
