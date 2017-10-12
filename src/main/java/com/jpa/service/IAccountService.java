package com.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.entity.Account;

@Service
public interface IAccountService {
	
	public List<Account> getAllAccounts();
	public Account getAccount(int id);
	public Account getAccountByAccountNumber(String accountNumber);
	public boolean addAccount(Account account);

}
