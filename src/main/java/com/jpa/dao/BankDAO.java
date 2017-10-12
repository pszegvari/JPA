package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.entity.Bank;

@Repository
@Transactional
public class BankDAO implements IBankDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Bank> getAllBanks() {
		return entityManager.createQuery("from Bank order by id").getResultList();
	}

	@Override
	public Bank getBank(int id) {
		return entityManager.find(Bank.class, Integer.valueOf(id));
	}

	@Override
	public Bank getBankByName(String bankName) {
		return (Bank) entityManager.createQuery("from Bank where name = ?").setParameter(1, bankName).getResultList().get(0);
	}

	@Override
	public boolean existsBank(String bankName) {
		return !entityManager.createQuery("from Bank where name = ?").setParameter(1, bankName).getResultList().isEmpty();
	}

	@Override
	public void addBank(Bank bank) {
		entityManager.persist(bank);
	}
}
