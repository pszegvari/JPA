package com.jpa.service;

import java.util.List;

import com.jpa.entity.Bank;

public interface IBankService {
	public List<Bank> getAllBanks();
	public Bank getBank(int id);
	public Bank getBankByName(String bankName);
	public boolean addBank(Bank bank);
	public int addBanks(Bank[] banks);

}
