package com.bagoudou.bankaccount.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACCOUNT_ID")
    private Long accountId;
    
    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "BALANCE")
    private Long balance;
    
    @OneToMany(mappedBy="account")
    private Set<TransactionHistory> transactionHistory;
    
    

	/**
	 * @param accountId
	 * @param username
	 * @param balance
	 */
	public Account(String username, Long balance) {
		super();
		this.username = username;
		this.balance = balance;
	}

	/**
	 * @return the accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the balance
	 */
	public Long getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Long balance) {
		this.balance = balance;
	}

	/**
	 * @return the transactionHistory
	 */
	public Set<TransactionHistory> getTransactionHistory() {
		return transactionHistory;
	}

	/**
	 * @param transactionHistory the transactionHistory to set
	 */
	public void setTransactionHistory(Set<TransactionHistory> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	
	
    
    
}
