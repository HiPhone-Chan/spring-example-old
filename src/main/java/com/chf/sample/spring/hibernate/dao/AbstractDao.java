package com.chf.sample.spring.hibernate.dao;

import java.util.List;

public interface AbstractDao<T> {

	void save(T t);

	void delete(T t);

	void update(T t);

	List<T> query(T t);

	List<T> queryAll();

	T getByID(Long id);
}
