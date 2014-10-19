package com.chf.sample.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.domain.A;

@RestController
public class HelloController {

	@Autowired
	private A a;

	@RequestMapping("/hi/{name}")
	public String index(@PathVariable("name") String name) {
		return String.format("Hello,  %s.", name);
	}

	@RequestMapping("/a")
	@Autowired
	public A getA() {
		a.setId(a.getId() + 1);
		return a;
	}
}
