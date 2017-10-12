package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.dao.AccountAssignmentDAO;
import com.jpa.entity.AccountAssignment;

@Service
public class AccountAssignmentService implements IAccountAssignmentService{
	
	@Autowired
	private AccountAssignmentDAO aaDao;

	@Override
	public List<AccountAssignment> getAccountAssignments() {
		return aaDao.getAccountAssignments();
	}

	@Override
	public AccountAssignment getAccountAssignment(int id) {
		return aaDao.getAccountAssignment(id);
	}

	@Override
	public List<AccountAssignment> getAccountAssignmentsByCustomerId(int customerId) {
		return aaDao.getAccountAssignmentsByCustomerId(customerId);
	}

	@Override
	public List<AccountAssignment> getAccountAssignmentsByAccountId(int accountId) {
		return aaDao.getAccountAssignmentsByAccountId(accountId);
	}

	@Override
	public boolean existsAccountForCustomer(int customerId) {
		return !getAccountAssignmentsByCustomerId(customerId).isEmpty();
	}

	@Override
	public boolean existsCustomerForAccount(int accountId) {
		return !getAccountAssignmentsByAccountId(accountId).isEmpty();
	}

	@Override
	public boolean existsAccountAssignment(int customerId, int accountId) {
		return aaDao.getAccountAssigment(customerId, accountId) != null;
	}
	
	@Override
	public synchronized boolean addAccountAssignment(AccountAssignment accountAssigment) {
		if (existsAccountAssignment(accountAssigment.getCustomerId(), accountAssigment.getAccountId())) {
			return false;
		}
		aaDao.addAccountAssignment(accountAssigment);
		return true;
	}

	public int addAccountAssignment(AccountAssignment[] assignmentArray) {
		int counter = 0;
		for (AccountAssignment ass : assignmentArray) 
			if (addAccountAssignment(ass)) {
				counter++;
			}
		return counter;
	}


}
