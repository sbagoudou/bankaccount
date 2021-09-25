package com.bagoudou.bankaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bagoudou.bankaccount.model.Account;
import com.bagoudou.bankaccount.service.IAccountService;

@RestController
public class MainController {

	@Autowired
	private IAccountService accountService;

	@RequestMapping("/")
	public String home() {
		System.out.println("Creating default account to interact with");
		Account defaultAccount = new Account("DEFAULT_USER", 5000L);
		accountService.save(defaultAccount);
		return "Welcome! Default account created";
	}

}
