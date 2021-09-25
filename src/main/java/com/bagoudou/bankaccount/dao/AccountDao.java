package com.bagoudou.bankaccount.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.bagoudou.bankaccount.model.Account;

@Repository
public class AccountDao extends GenericDao<Account> implements IAccountDao {

	@Override
	public Account findByUserName(String username) {
		Query<?> query = getCurrentSession().createQuery("from Account where username=:username");
		query.setParameter("username", username);
		return (Account) query.uniqueResult(); 
	}

}
