package com.chf.sample.spring.hibernate.dao;

import java.util.List;

import com.chf.sample.domain.Event;

public interface EventDao {
	void save(Event t);

	List<Event> query();

	Event getById(Long id);
}
