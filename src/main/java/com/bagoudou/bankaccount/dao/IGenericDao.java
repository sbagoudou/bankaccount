package com.bagoudou.bankaccount.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {

	public T findOne(long id);

	public List<T> findAll();

	public void save(T entity);

	public T update(T entity);

	public void delete(T entity);

	public void deleteById(long id);
}
