package com.chf.sample.spring.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Dao<T> {

	@Autowired
	private SessionFactory sessionFactory;

	// public void save(T t) {
	//
	// }
	//
	// public T getByID(Long id) {
	// return (T) getSession().get(super.getClass(), id);
	// }
	//
	// public List<T> query() {
	// List<T> list = null;
	// return list;
	// }

	public Session getSession() {
		return sessionFactory.getCurrentSession();
		// return sessionFactory.openSession();
	}
}
