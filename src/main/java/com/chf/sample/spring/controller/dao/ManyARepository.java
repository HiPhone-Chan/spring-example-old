package com.chf.sample.spring.controller.dao;

import org.springframework.data.repository.CrudRepository;

import com.chf.sample.domain.ManyA;

public interface ManyARepository extends CrudRepository<ManyA, Long> {

}
