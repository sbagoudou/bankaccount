package com.bagoudou.bankaccount.service;

import java.util.List;

import com.bagoudou.bankaccount.model.Account;

public interface IAccountService {
	
	public Account findOne(long id);

	public List<Account> findAll();

	public void save(Account entity);

	public Account update(Account entity);

	public void delete(Account entity);

	public void deleteById(long id);

}
