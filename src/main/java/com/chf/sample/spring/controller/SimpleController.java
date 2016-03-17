package com.chf.sample.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.domain.A;

@RestController
public class SimpleController extends BaseController {

	@RequestMapping(value = "/chf", method = RequestMethod.GET)
	public @ResponseBody String index(
			@RequestParam(value = "name", required = false, defaultValue = "chf") String name) {
		String param = req.getParameter("param");
		if ("123".equals(param)) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		}
		return String.format("Hi, %s", param);
	}

	@RequestMapping(value = "/hi/{name}", method = RequestMethod.GET)
	public String hi(@PathVariable("name") String name) {
		return String.format("Hello,  %s.", name);
	}

	@RequestMapping(value = "/a", method = RequestMethod.GET)
	@Autowired
	public A getA(A a) {
		a.setId(a.getId() + 1);
		return a;
	}
}
