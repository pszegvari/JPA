package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.dao.BankDAO;
import com.jpa.entity.Bank;
import com.jpa.utility.Utility;

@Service
public class BankService implements IBankService{

	@Autowired
	private BankDAO bankDao;
	
	@Override
	public List<Bank> getAllBanks() {
		return bankDao.getAllBanks();
	}

	@Override
	public Bank getBank(int id) {
		return bankDao.getBank(id);
	}

	@Override
	public Bank getBankByName(String bankName) {
		return bankDao.getBankByName(bankName);
	}

	@Override
	public synchronized boolean addBank(Bank bank) {
		if (Utility.addressExistsWithId(bank.getAddressId())) {
			return false;
		}
		if (bankDao.existsBank(bank.getName())) {
			return false;
		}
		bankDao.addBank(bank);
		return true;
	}

	@Override
	public int addBanks(Bank[] banks) {
		int counter = 0;
		for (Bank bank : banks) {
			if (addBank(bank)) {
				counter++;
			}
		}
		return counter;
	}
	
	

}
