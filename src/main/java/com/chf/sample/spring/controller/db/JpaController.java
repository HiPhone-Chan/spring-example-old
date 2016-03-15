package com.chf.sample.spring.controller.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.domain.Event;
import com.chf.sample.domain.ManyA;
import com.chf.sample.domain.One;
import com.chf.sample.spring.controller.dao.EventRepository;
import com.chf.sample.spring.controller.dao.ManyARepository;
import com.chf.sample.spring.controller.dao.ManyBRepository;
import com.chf.sample.spring.controller.dao.OneRepository;

@RestController
@Transactional
@RequestMapping("/jpa")
public class JpaController {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private OneRepository oneRepository;

	@Autowired
	private ManyARepository manyARepository;

	@Autowired
	private ManyBRepository manyBRepository;

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public List<Event> queryAll() {

		List<Event> list = new ArrayList<Event>();

		eventRepository.findAll().forEach(e -> list.add(e));

		return list;
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save() {
		Event e = new Event();
		e.setTitle("title");
		e.setDate(new Date());
		eventRepository.save(e);
		return String.format("Save!");
	}

	@RequestMapping(value = "/one2one", method = RequestMethod.GET)
	public One one2one(@RequestHeader(value = "id", required = false) Long id) {
		if (StringUtils.isEmpty(id)) {
			One one1 = new One();
			one1.setValue("1");
			oneRepository.save(one1);
			One one2 = new One();
			one2.setValue("2");
			one2.setOne(one1);
			oneRepository.save(one2);
			return one2;
		}

		One result = oneRepository.findOne(id);
		return result;
	}

	@RequestMapping(value = "/one2many", method = RequestMethod.GET)
	public One one2many(
			@RequestHeader(value = "id", required = false) Long id) {
		if (StringUtils.isEmpty(id)) {
			One one = new One();
			one.setValue("1");
			oneRepository.save(one);

			List<ManyA> list = new ArrayList<>();
			ManyA manyA1 = new ManyA();
			manyA1.setValue("m1");
			manyARepository.save(manyA1);
			ManyA manyA2 = new ManyA();
			manyA2.setValue("m2");
			manyARepository.save(manyA2);
			list.add(manyA1);
			list.add(manyA2);
			one.setManys(list);
			return one;
		}

		One result = oneRepository.findOne(id);
		return result;
	}
}
