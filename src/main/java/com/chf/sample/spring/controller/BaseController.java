package com.chf.sample.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@RequestMapping("/base")
public class BaseController {

	@Autowired
	protected WebRequest req;
}
