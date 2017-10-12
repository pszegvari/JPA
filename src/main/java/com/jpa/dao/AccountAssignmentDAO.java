package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.entity.AccountAssignment;

@Repository
@Transactional
public class AccountAssignmentDAO implements IAccountAssignmentDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountAssignment> getAccountAssignments() {
		return entityManager.createQuery("from AccountAssignment order by id").getResultList();
	}

	@Override
	public AccountAssignment getAccountAssignment(int id) {
		return entityManager.find(AccountAssignment.class, Integer.valueOf(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountAssignment> getAccountAssignmentsByCustomerId(int customerId) {
		return entityManager.createQuery("from AccountAssignment where customerid = ?").setParameter(1, Integer.valueOf(customerId)).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AccountAssignment> getAccountAssignmentsByAccountId(int accountId) {
		return entityManager.createQuery("from AccountAssignment where accountid = ?").setParameter(1, Integer.valueOf(accountId)).getResultList();
	}

	@Override
	public void addAccountAssignment(AccountAssignment accountAssigment) {
		entityManager.persist(accountAssigment);
	}

	@Override
	public AccountAssignment getAccountAssigment(int customerId, int accountId) {
		return (AccountAssignment) entityManager.createQuery("from AccountAssignment where customerid = ? and accountid = ?").setParameter(1,  Integer.valueOf(customerId)).setParameter(2, Integer.valueOf(accountId)).getResultList().get(0);
	}


}
