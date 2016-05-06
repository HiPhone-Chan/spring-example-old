package com.chf.sample.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chf.sample.spring.service.Receiver;

import reactor.Environment;
import reactor.bus.EventBus;
import reactor.bus.selector.ObjectSelector;

@Configuration
public class ReactorConfig {

	@Autowired
	private Receiver receiver;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public EventBus createEventBus() {
		Environment env = Environment.initializeIfEmpty().assignErrorJournal();
		EventBus eventBus = EventBus.create(env, Environment.THREAD_POOL);

		eventBus.on(new ObjectSelector(Receiver.KEY), receiver);
		return eventBus;
	}

}
