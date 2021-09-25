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
	 * 
	 */
	public TransactionHistory() {
		super();
	}

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionHistory other = (TransactionHistory) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (payee == null) {
			if (other.payee != null)
				return false;
		} else if (!payee.equals(other.payee))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransactionHistory [transactionId=" + transactionId + ", account=" + account + ", payee=" + payee
				+ ", amount=" + amount + "]";
	}
    
	
    
}
