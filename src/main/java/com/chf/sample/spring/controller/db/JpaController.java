package com.chf.sample.spring.controller.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.domain.Event;
import com.chf.sample.spring.controller.dao.EventRepository;

@RestController
@Transactional
@RequestMapping("/jpa")
public class JpaController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping("/query")
    public List<Event> queryAll() {

        List<Event> list = new ArrayList<Event>();

        eventRepository.findAll().forEach(e -> list.add(e));

        return list;
    }

    @RequestMapping("/save")
    public String save() {
        Event e = new Event();
        e.setTitle("title");
        e.setDate(new Date());
        eventRepository.save(e);
        return String.format("Save!");
    }
}
