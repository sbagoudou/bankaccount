package com.bagoudou.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bagoudou.bankaccount.model.Account;
import com.bagoudou.bankaccount.model.TransactionHistory;
import com.bagoudou.bankaccount.service.IAccountService;
import com.bagoudou.bankaccount.service.ITransactionHistoryService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class TransactionHistoryServiceTest {

	@Autowired
	private ITransactionHistoryService transactionHistoryService;

	@Autowired
	private IAccountService accountService;

	private static TransactionHistory transactionHistory;
	private static Long id;
	private Account account;

	@Test
	@Order(1)
	void saveTest() {
		account = new Account("TEST_USER", 0L);
		accountService.save(account);

		transactionHistory = new TransactionHistory(account, 0L, 0L);
		transactionHistoryService.save(transactionHistory);
		id = transactionHistory.getTransactionId();

		assertNotNull(id);
	}

	@Test
	@Order(2)
	void findOneTest() {
		TransactionHistory transactionHistory = transactionHistoryService.findOne(id);
		assertEquals("TEST_USER", transactionHistory.getAccount().getUsername());
	}

	@Test
	@Order(3)
	void findAllTest() {
		List<TransactionHistory> transactionHistoryList = transactionHistoryService.findAll();
		assertEquals("TEST_USER", transactionHistoryList.get(0).getAccount().getUsername());
	}

	@Test
	@Order(4)
	void updateTest() {
		transactionHistory.setAmount(1000L);
		transactionHistory = transactionHistoryService.update(transactionHistory);
		assertEquals(1000L, transactionHistory.getAmount());
	}

	@Test
	@Order(5)
	void deleteByIdTest() {
		transactionHistoryService.deleteById(id);
		assertNull(transactionHistoryService.findOne(id));
	}

	@Test
	@Order(6)
	void deleteTest() {
		account = new Account("NEW_USER", 0L);
		accountService.save(account);

		transactionHistory = new TransactionHistory(account, 0L, 0L);
		transactionHistoryService.save(transactionHistory);
		id = transactionHistory.getTransactionId();

		accountService.save(new Account("OTHER_USER", 0L));
		transactionHistoryService.delete(transactionHistory);
		assertNull(transactionHistoryService.findOne(id));
	}

}
