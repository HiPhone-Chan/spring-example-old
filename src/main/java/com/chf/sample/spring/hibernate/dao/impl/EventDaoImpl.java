package com.chf.sample.spring.hibernate.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chf.sample.domain.Event;
import com.chf.sample.spring.hibernate.dao.Dao;
import com.chf.sample.spring.hibernate.dao.EventDao;

@Repository
public class EventDaoImpl extends Dao<Event> implements EventDao {

	@Override
	public void save(Event e) {
		getSession().save(e);
	}

	@Override
	public List<Event> query() {
		return null;
	}

	@Override
	public Event getById(Long id) {
		return (Event) getSession().get(Event.class, id);
	}

}
