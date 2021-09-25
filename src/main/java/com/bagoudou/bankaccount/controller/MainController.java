package com.bagoudou.bankaccount.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bagoudou.bankaccount.model.Account;
import com.bagoudou.bankaccount.model.TransactionHistory;
import com.bagoudou.bankaccount.service.IAccountService;
import com.bagoudou.bankaccount.service.ITransactionHistoryService;

@RestController
public class MainController {

	@Autowired
	private IAccountService accountService;

	@Autowired
	private ITransactionHistoryService transactionHistoryService;

	@GetMapping("/")
	public String home() {

		if (accountService.findByUserName("DEFAULT_USER") == null) {
			System.out.println("Creating default account to interact with");
			Account defaultAccount = new Account("DEFAULT_USER", 5000L);
			accountService.save(defaultAccount);
		}

		return "Welcome! Default account created";
	}

	/**
	 * Create a new account
	 * 
	 * @param amount
	 * @return
	 */
	@GetMapping("/account/{username}")
	String newAccount(@PathVariable String username) {
		accountService.save(new Account(username, 0L));
		return username + "'s account created!";
	}

	/**
	 * Deposit a valid amount of money to the account
	 * 
	 * @param amount
	 * @return
	 */
	@GetMapping("/account/deposit")
	String deposit(@RequestParam String username, @RequestParam String amount) {
		int amountInt;
		try {
			amountInt = Integer.parseInt(amount);
		} catch (Exception e) {
			return "The amount parameter is not a valid number";
		}

		Account account = accountService.findByUserName(username);
		if (account == null) {
			return "The user account does not exist";
		}

		account.setBalance(account.getBalance() + amountInt);
		accountService.update(account);

		return "Deposit successful! new balance:" + account.getBalance();
	}

	/**
	 * Withdraw a valid amount of money from the account
	 * 
	 * @param amount
	 * @return
	 */
	@GetMapping("/account/withdraw")
	String withdraw(@RequestParam String username, @RequestParam String amount) {
		int amountInt;
		try {
			amountInt = Integer.parseInt(amount);
		} catch (Exception e) {
			return "The amount parameter is not a valid number";
		}

		Account account = accountService.findByUserName(username);
		if (account == null) {
			return "The user account does not exist";
		}

		if (account.getBalance() < amountInt) {
			return "Not enough money, actual balance is " + account.getBalance();
		}

		account.setBalance(account.getBalance() - amountInt);
		accountService.update(account);

		return "Withdraw successful! new balance:" + account.getBalance();
	}

	/**
	 * Transfer money from one account to another (with history)
	 * 
	 * @param payer
	 * @param payee
	 * @param amount
	 * @return
	 */
	@GetMapping("/transfer")
	@ResponseBody
	public String transfer(@RequestParam String payer, @RequestParam String payee, @RequestParam String amount) {
		int amountInt;
		try {
			amountInt = Integer.parseInt(amount);
		} catch (Exception e) {
			return "The amount parameter is not a valid number";
		}

		Account payerAccount = accountService.findByUserName(payer);
		Account payeeAccount = accountService.findByUserName(payee);
		if (payerAccount == null || payeeAccount == null) {
			return "Either payer account or payee account does not exist";
		}

		if (payerAccount.getBalance() < amountInt) {
			return "Not enough money, actual balance is " + payerAccount.getBalance();
		}

		payerAccount.setBalance(payerAccount.getBalance() - amountInt);
		TransactionHistory history = new TransactionHistory(payerAccount, payeeAccount.getAccountId(),
				Long.valueOf(amountInt));
		transactionHistoryService.save(history);
		payerAccount.getTransactionHistory().add(history);
		accountService.update(payerAccount);

		payeeAccount.setBalance(payeeAccount.getBalance() + amountInt);
		accountService.update(payeeAccount);

		return "Transfer successful! new payer balance:" + payerAccount.getBalance();
	}

	/**
	 * Get user's transactions history
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping("/history/{username}")
	String userHistory(@PathVariable String username) {
		Account account = accountService.findByUserName(username);

		if (account != null) {
			StringBuilder sb = new StringBuilder();
			account.getTransactionHistory().stream().forEach(history -> {
				sb.append("" + history.getAccount().getUsername())
				.append(" sent "+history.getAmount())
				.append(" to user ID "+history.getPayee());
			});
			return sb.toString();
		}
		return "Account does not exist";
	}

}
