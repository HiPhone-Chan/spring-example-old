package com.chf.sample.spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.domain.A;

@RestController
public class HelloController {

	@RequestMapping("/hello/{name}")
	public String index(@PathVariable("name") String name) {
		return String.format("Hello,  %s.", name);
	}

	@RequestMapping("/a")
	public A getA() {
		return new A(1, "good");
	}
}
