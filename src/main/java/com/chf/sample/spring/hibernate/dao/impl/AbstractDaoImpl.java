package com.chf.sample.spring.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

public abstract class AbstractDaoImpl<T> {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	protected HibernateTemplate hibernateTemplate;

	protected Class<T> cls;

	public void save(T t) {
		hibernateTemplate.save(t);
	}

	public void delete(T t) {
		hibernateTemplate.delete(t);
	}

	public void update(T t) {
		hibernateTemplate.update(t);
	}

	public List<T> query(T t) {
		return hibernateTemplate.findByExample(t);
	}

	public Object getByID(Long id) {
		return getSession().get(cls, id);
	}

	public List<T> queryAll() {
		return hibernateTemplate.loadAll(cls);
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}
