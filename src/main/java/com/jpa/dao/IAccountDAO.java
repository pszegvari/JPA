package com.jpa.dao;

import java.util.List;

import com.jpa.entity.Account;

public interface IAccountDAO {
	public List<Account> getAllAccounts();
	public Account getAccount(int id);
	public Account getAccountByAccountNumber(String accountNumber);
	public boolean existsAccount(String accountNumber);
	public void addAccount(Account account);
}
