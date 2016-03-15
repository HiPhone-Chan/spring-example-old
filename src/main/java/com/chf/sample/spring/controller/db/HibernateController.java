package com.chf.sample.spring.controller.db;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.domain.Event;
import com.chf.sample.spring.hibernate.dao.EventDao;

@RestController
@Transactional
@RequestMapping("/hibernate")
public class HibernateController {

	@Autowired
	private EventDao eventDao;

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public List<Event> queryAll() {
		return eventDao.queryAll();
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save() {
		Event e = new Event();
		e.setTitle("title");
		e.setDate(new Date());
		eventDao.save(e);
		return "Save!";
	}
}
