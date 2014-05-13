package com.chf.sample.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chf.sample.domain.Event;

@Controller
public class EventController {

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		model.addAttribute("event", new Event());
		return "event";
	}

	@RequestMapping(value = "/greeting", method = RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute Event event, Model model) {
		model.addAttribute("event", event);
		return "result";
	}
}
