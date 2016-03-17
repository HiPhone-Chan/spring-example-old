package com.chf.sample.spring.controller.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chf.sample.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);
}
