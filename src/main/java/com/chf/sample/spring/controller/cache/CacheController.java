package com.chf.sample.spring.controller.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cache")
public class CacheController {

	@Autowired
	private CacheService cacheService;

	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	public @ResponseBody String sayHi(@PathVariable String key) {
		return "Hi, " + cacheService.getValue(key);
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public @ResponseBody String update() {
		return "Hi, " + cacheService.update("get");
	}

}
