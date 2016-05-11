package com.chf.sample.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.bus.Event;
import reactor.bus.EventBus;

@Service
public class Publisher {

	public static final String KEY = "quotes";

	@Autowired
	private EventBus eventBus;

	public void publishQuotes(String message) throws InterruptedException {
		eventBus.notify(KEY, Event.wrap(message));
	}
}
