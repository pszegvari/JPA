package com.jpa.entity;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="accountnumber")
	private String accountNumber;
	
	@Column(name="bankid")
	private int bankId;
	
	@Column(name="balance")
	private BigInteger balance;
	
	@Column(name="credit")
	private BigInteger credit;
	
//	@ManyToMany(mappedBy="accountList")
//	private Set<Customer> customerList = new HashSet<Customer>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public BigInteger getBalance() {
		return balance;
	}

	public void setBalance(BigInteger balance) {
		this.balance = balance;
	}

	public BigInteger getCredit() {
		return credit;
	}

	public void setCredit(BigInteger credit) {
		this.credit = credit;
	}

}
