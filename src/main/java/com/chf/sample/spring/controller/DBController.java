package com.chf.sample.spring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.domain.Event;
import com.chf.sample.spring.hibernate.dao.EventDao;

@RestController
@Transactional
public class DBController {

	@Autowired
	private EventDao eventDao;

	@RequestMapping("/query")
	public String query() {

		return String.format("Hi, %s", "a");
	}

	@RequestMapping("/save")
	public String save() {
		Event e = new Event();
		e.setId(1L);
		e.setTitle("title");
		e.setDate(new Date());
		eventDao.save(e);
		return String.format("Save!");
	}
}
