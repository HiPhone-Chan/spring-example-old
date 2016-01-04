package com.chf.sample.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

import com.chf.sample.spring.config.StatemachineConfig.Events;
import com.chf.sample.spring.config.StatemachineConfig.States;

@Component
public class CommandLine implements CommandLineRunner {

	@Autowired
	private StateMachine<States, Events> stateMachine;

	@Override
	public void run(String... args) throws Exception {
		stateMachine.sendEvent(Events.E1);
		stateMachine.sendEvent(Events.E2);
	}
}
