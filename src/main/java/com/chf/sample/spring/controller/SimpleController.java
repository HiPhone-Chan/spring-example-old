package com.chf.sample.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController extends BaseController {

	@RequestMapping("/chf")
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
}
