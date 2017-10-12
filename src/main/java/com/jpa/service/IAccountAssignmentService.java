package com.jpa.service;

import java.util.List;

import com.jpa.entity.AccountAssignment;

public interface IAccountAssignmentService {

	public List<AccountAssignment> getAccountAssignments();
	public AccountAssignment getAccountAssignment(int id);
	public List<AccountAssignment> getAccountAssignmentsByCustomerId(int customerId);
	public List<AccountAssignment> getAccountAssignmentsByAccountId(int accountId);
	public boolean existsAccountForCustomer(int customerId);
	public boolean existsCustomerForAccount(int accountId);
	public boolean addAccountAssignment(AccountAssignment accountAssigment);
	public boolean existsAccountAssignment(int customerId, int accountId);
}
