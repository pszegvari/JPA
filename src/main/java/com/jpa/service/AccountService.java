package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.dao.AccountDAO;
import com.jpa.entity.Account;

@Service
public class AccountService implements IAccountService{

	@Autowired
	private AccountDAO accountDao;
	
	@Override
	public List<Account> getAllAccounts() {
		return accountDao.getAllAccounts();
	}

	@Override
	public Account getAccount(int id) {
		return accountDao.getAccount(id);
	}

	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		return accountDao.getAccountByAccountNumber(accountNumber);
	}

	@Override
	public synchronized boolean addAccount(Account account) {
		if (accountDao.existsAccount(account.getAccountNumber())) {
			return false;
		}
		accountDao.addAccount(account);
		return true;
	}

	public int addAccount(Account[] accountArray) {
		int counter = 0;
		for (Account acc : accountArray) {
			if (addAccount(acc)) {
				counter++;
			}
		}
		return counter;
		
	}
	
}
