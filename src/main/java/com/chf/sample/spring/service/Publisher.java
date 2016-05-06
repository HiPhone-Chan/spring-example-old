package com.chf.sample.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.bus.Event;
import reactor.bus.EventBus;

@Service
public class Publisher {

	@Autowired
	private EventBus eventBus;

	public void publishQuotes(String message) throws InterruptedException {
		eventBus.notify(Receiver.KEY, Event.wrap(message));
	}
}
