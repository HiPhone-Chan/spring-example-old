package com.chf.sample.spring.hibernate.dao.impl;

import org.springframework.stereotype.Repository;

import com.chf.sample.domain.Event;
import com.chf.sample.spring.hibernate.dao.EventDao;

@Repository
public class EventDaoImpl extends AbstractDaoImpl<Event> implements EventDao {

	public EventDaoImpl() {
		cls = Event.class;
	}

	public Event getByID(Long id) {
		return (Event) super.getByID(id);
	}
}
