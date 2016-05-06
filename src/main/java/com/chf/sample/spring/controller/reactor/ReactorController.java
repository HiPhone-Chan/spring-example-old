package com.chf.sample.spring.controller.reactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.spring.service.Publisher;

@RestController
@RequestMapping("/reactor")
public class ReactorController {

	@Autowired
	private Publisher publisher;

	@RequestMapping(value = "/publish", method = RequestMethod.GET)
	public String publish(@RequestParam String msg) throws InterruptedException {
		publisher.publishQuotes(msg);
		return "Publish : " + msg;
	}
}
