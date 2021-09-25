package com.bagoudou.bankaccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagoudou.bankaccount.dao.IAccountDao;
import com.bagoudou.bankaccount.model.Account;

@Service
@Transactional
public class AccountService implements IAccountService {

	@Autowired
	private IAccountDao accountDao;

	@Override
	public Account findOne(long id) {
		return accountDao.findOne(id);
	}

	@Override
	public List<Account> findAll() {
		return accountDao.findAll();
	}

	@Override
	public void save(Account entity) {
		accountDao.save(entity);
		
	}

	@Override
	public Account update(Account entity) {
		return accountDao.update(entity);
	}

	@Override
	public void delete(Account entity) {
		accountDao.delete(entity);
		
	}

	@Override
	public void deleteById(long id) {
		accountDao.deleteById(id);
		
	}
}
