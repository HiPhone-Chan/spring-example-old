package com.chf.sample.spring.controller.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.chf.sample.domain.Event;

public interface EventMapper {

    @Select("SELECT * FROM event WHERE id = #{id}")
    Event getEvent(@Param("id") Long id);

    @Select("SELECT * FROM event")
    List<Event> queryAll();

    void insert(Event e);
}
