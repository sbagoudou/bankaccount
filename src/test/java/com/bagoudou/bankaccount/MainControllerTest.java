package com.bagoudou.bankaccount;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class MainControllerTest {

	private static final String BASE_PATH = "http://localhost:8080/";
	private static final String ACCOUNT_PATH = "account/test";
	private static final String DEPOSIT_PATH = "account/deposit?username=&amount=";
	private static final String WITHDRAW_PATH = "account/withdraw?username=&amount=";
	private static final String TRANSFER_PATH = "transfer?payer=&payee=&amount=";
	private static final String HISTORY_PATH = "history/test";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void addAccountUrlIsOk() throws Exception {
		this.mockMvc.perform(get(BASE_PATH+ACCOUNT_PATH)).andExpect(status().isOk());
	}

	@Test
	public void depositUrlIsOk() throws Exception {
		this.mockMvc.perform(get(BASE_PATH + DEPOSIT_PATH)).andExpect(status().isOk());
	}
	
	@Test
	public void withdrawUrlIsOk() throws Exception {
		this.mockMvc.perform(get(BASE_PATH + WITHDRAW_PATH)).andExpect(status().isOk());
	}
	
	@Test
	public void transferUrlIsOk() throws Exception {
		this.mockMvc.perform(get(BASE_PATH + TRANSFER_PATH)).andExpect(status().isOk());
	}
	
	@Test
	public void historyUrlIsOk() throws Exception {
		this.mockMvc.perform(get(BASE_PATH + HISTORY_PATH)).andExpect(status().isOk());
	}

}
