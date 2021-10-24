package com.bagoudou.bankaccount.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ACCOUNT")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @EqualsAndHashCode
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
    
    @OneToMany(mappedBy="account", fetch = FetchType.EAGER)
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
    
}
