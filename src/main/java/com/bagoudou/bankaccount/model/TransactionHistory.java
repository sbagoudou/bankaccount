package com.bagoudou.bankaccount.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION_HISTORY")
public class TransactionHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @ManyToOne
    @JoinColumn(name="ACCOUNT_ID", nullable=false)
    private Account account;
    
    @Column(name = "PAYEE")
    private Long payee;
    
    @Column(name = "AMOUNT")
    private Long amount;

	/**
	 * @param transactionId
	 * @param accoundId
	 * @param payee
	 * @param amount
	 */
	public TransactionHistory(Account account, Long payee, Long amount) {
		super();
		this.account = account;
		this.payee = payee;
		this.amount = amount;
	}

	/**
	 * @return the transactionId
	 */
	public Long getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccoundId(Account account) {
		this.account = account;
	}

	/**
	 * @return the payee
	 */
	public Long getPayee() {
		return payee;
	}

	/**
	 * @param payee the payee to set
	 */
	public void setPayee(Long payee) {
		this.payee = payee;
	}

	/**
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}
    
    
}
