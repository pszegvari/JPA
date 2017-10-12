package com.jpa.controller;

import java.math.BigInteger;

public class AccountDTO {
	private int id;

	private String accountNumber;

	private int bankId;

	private BigInteger balance;

	private BigInteger credit;
	
	

	public AccountDTO(int id, String accountNumber, int bankId, BigInteger balance, BigInteger credit) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.bankId = bankId;
		this.balance = balance;
		this.credit = credit;
	}

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
