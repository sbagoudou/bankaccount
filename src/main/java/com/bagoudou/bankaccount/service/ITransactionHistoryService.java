package com.bagoudou.bankaccount.service;

import java.util.List;
import com.bagoudou.bankaccount.model.TransactionHistory;

public interface ITransactionHistoryService {

	public TransactionHistory findOne(long id);

	public List<TransactionHistory> findAll();

	public void save(TransactionHistory entity);

	public TransactionHistory update(TransactionHistory entity);

	public void delete(TransactionHistory entity);

	public void deleteById(long id);

}
