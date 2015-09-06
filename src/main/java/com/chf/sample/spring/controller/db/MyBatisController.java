package com.chf.sample.spring.controller.db;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chf.sample.domain.Event;
import com.chf.sample.spring.controller.dao.EventMapper;

@RestController
@Transactional
@RequestMapping("/mybatis")
public class MyBatisController {

    @Autowired
    private EventMapper eventMapper;

    @RequestMapping("/query")
    public List<Event> queryAll() {
        return eventMapper.queryAll();
    }

    @RequestMapping("/save")
    public String save() {
        Event e = new Event();
        e.setTitle("title");
        e.setDate(new Date());
        eventMapper.insert(e);
        return "Save!";
    }
}
