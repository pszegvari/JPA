package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.entity.Account;

@Transactional
@Repository
public class AccountDAO implements IAccountDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAllAccounts() {
		return (List<Account>) entityManager.createQuery("from Account order by id").getResultList();
	}

	@Override
	public Account getAccount(int id) {
		return (Account) entityManager.find(Account.class, Integer.valueOf(id));
	}

	@Override
	public Account getAccountByAccountNumber(String accountNumber) {
		return (Account) entityManager.createQuery("from Account where accountNumber = ?").setParameter(1, accountNumber).getResultList().get(0);
	}

	@Override
	public boolean existsAccount(String accountNumber) {
		return !entityManager.createQuery("from Account where accountNumber = ?").setParameter(1, accountNumber).getResultList().isEmpty();
	}

	@Override
	public void addAccount(Account account) {
		entityManager.persist(account);
	}

}
