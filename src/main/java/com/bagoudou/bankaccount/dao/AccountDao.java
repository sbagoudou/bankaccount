package com.bagoudou.bankaccount.dao;

import org.springframework.stereotype.Repository;

import com.bagoudou.bankaccount.model.Account;

@Repository
public class AccountDao extends GenericDao<Account> implements IAccountDao {

}
