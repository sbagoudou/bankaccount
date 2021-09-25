package com.bagoudou.bankaccount.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDao<T extends Serializable> implements IGenericDao<T> {

	private Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory; 

	/**
	* Default constructor
	*/
	public GenericDao() {
		clazz = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}


	public T findOne(long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	public List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName()).list();
	}

	public void save(T entity) {
		getCurrentSession().persist(entity);
	}

	public T update(T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(long id) {
		final T entity = findOne(id);
		delete(entity);
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
