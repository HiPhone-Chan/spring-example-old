package com.chf.sample.spring.controller.dao;

import org.springframework.data.repository.CrudRepository;

import com.chf.sample.domain.Event;

public interface EventRepository extends CrudRepository<Event, Long> {

}
