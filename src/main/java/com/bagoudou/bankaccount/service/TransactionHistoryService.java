package com.bagoudou.bankaccount.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bagoudou.bankaccount.dao.ITransactionHistoryDao;
import com.bagoudou.bankaccount.model.TransactionHistory;

@Service
@Transactional
public class TransactionHistoryService implements ITransactionHistoryService {

	@Autowired
	private ITransactionHistoryDao transactionHistoyDao;

	@Override
	public TransactionHistory findOne(long id) {
		return transactionHistoyDao.findOne(id);
	}

	@Override
	public List<TransactionHistory> findAll() {
		return transactionHistoyDao.findAll();
	}

	@Override
	public void save(TransactionHistory entity) {
		transactionHistoyDao.save(entity);
		
	}

	@Override
	public TransactionHistory update(TransactionHistory entity) {
		return transactionHistoyDao.update(entity);
	}

	@Override
	public void delete(TransactionHistory entity) {
		transactionHistoyDao.delete(entity);
		
	}

	@Override
	public void deleteById(long id) {
		transactionHistoyDao.deleteById(id);
		
	}
}
