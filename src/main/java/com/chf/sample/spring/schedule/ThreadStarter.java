package com.chf.sample.spring.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class ThreadStarter implements InitializingBean {

	public void afterPropertiesSet() throws Exception {
		// start();
	}

	public void start() {
		Runnable runnable = new ReadPropertiesRunnable();
		long initialDelay = 1000L;
		long period = 5000L;
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(
				runnable, initialDelay, period, TimeUnit.MILLISECONDS);
	}
}
