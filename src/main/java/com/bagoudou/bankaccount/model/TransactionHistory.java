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

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "TRANSACTION_HISTORY")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
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

}
