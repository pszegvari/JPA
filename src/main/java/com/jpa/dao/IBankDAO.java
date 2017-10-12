package com.jpa.dao;

import java.util.List;

import com.jpa.entity.Bank;

public interface IBankDAO {

	public List<Bank> getAllBanks();
	public Bank getBank(int id);
	public Bank getBankByName(String bankName);
	public boolean existsBank(String bankName);
	public void addBank(Bank bank);
}
