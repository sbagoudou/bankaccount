package com.bagoudou.bankaccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bagoudou.bankaccount.model.Account;
import com.bagoudou.bankaccount.service.IAccountService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AccountServiceTest {
	
	@Autowired
	private IAccountService accountService;
	
	public static Account account;
	private static Long id;
	
	@BeforeAll
	static void intitObject() {
		account = new Account("TEST_USER", 0L);
	}

	@Test
	@Order(1) 
	void saveTest() {
		accountService.save(account);
		id = account.getAccountId();
		assertNotNull(id);
	}
	
	@Test
	@Order(2) 
	void findOneTest() {
		Account account = accountService.findOne(id); 
		assertEquals("TEST_USER", account.getUsername());
	}
	
	@Test
	@Order(3) 
	void findAllTest() {
		List<Account> accountList = accountService.findAll(); 
		assertEquals("TEST_USER", accountList.get(0).getUsername());
	}
	
	@Test
	@Order(4) 
	void updateTest() {
		account.setBalance(1000L);
		account = accountService.update(account); 
		assertEquals(1000L, account.getBalance());
	}
	
	@Test
	@Order(5) 
	void findByUserNameTest() {
		account = accountService.findByUserName("TEST_USER"); 
		assertEquals("TEST_USER", account.getUsername());
	}
	
	@Test
	@Order(6) 
	void deleteByIdTest() {
		accountService.deleteById(id); 
		assertNull(accountService.findOne(id));
	}
	
	@Test
	@Order(7) 
	void deleteTest() {
		accountService.save(new Account("OTHER_USER", 0L));
		account = accountService.findByUserName("OTHER_USER");
		accountService.delete(account); 
		assertNull(accountService.findByUserName("OTHER_USER"));
	}

}
