package com.chf.sample.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chf.sample.domain.Event;

@Controller
public class EventController {

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greetingForm(Event event) {
		// model.addAttribute("event", new Event());
		return "event";
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.POST)
	public String greetingSubmit(@Valid Event event, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "event";
		}
		return "result";
	}
}
