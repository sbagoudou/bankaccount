package com.bagoudou.bankaccount.dao;

import com.bagoudou.bankaccount.model.Account;

public interface IAccountDao extends IGenericDao<Account> {

	public Account findByUserName(String username);
}
