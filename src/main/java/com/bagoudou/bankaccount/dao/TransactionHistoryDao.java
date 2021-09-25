package com.bagoudou.bankaccount.dao;

import org.springframework.stereotype.Repository;
import com.bagoudou.bankaccount.model.TransactionHistory;

@Repository
public class TransactionHistoryDao extends GenericDao<TransactionHistory> implements ITransactionHistoryDao {

}
