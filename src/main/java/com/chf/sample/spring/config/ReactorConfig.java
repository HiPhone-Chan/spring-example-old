package com.chf.sample.spring.config;

import static reactor.bus.selector.Selectors.$;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chf.sample.spring.service.Publisher;
import com.chf.sample.spring.service.Receiver;
import com.chf.sample.spring.service.Receiver2;

import reactor.Environment;
import reactor.bus.EventBus;

@Configuration
public class ReactorConfig {

	@Autowired
	private Receiver receiver;

	@Autowired
	private Receiver2 receiver2;

	@Bean
	public EventBus createEventBus() {
		Environment env = Environment.initializeIfEmpty().assignErrorJournal();
		EventBus eventBus = EventBus.create(env, Environment.THREAD_POOL);

		eventBus.on($(Publisher.KEY), receiver);
		eventBus.on($(Publisher.KEY), receiver2);
		return eventBus;
	}

}
