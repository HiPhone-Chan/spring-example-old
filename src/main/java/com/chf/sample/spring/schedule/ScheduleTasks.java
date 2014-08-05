package com.chf.sample.spring.schedule;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ScheduleTasks {

	private DateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:MM:ss");

	// @Scheduled(fixedRate = 5000)
	public void task() {
		System.out.println(format.format(new Date()));
	}
}
