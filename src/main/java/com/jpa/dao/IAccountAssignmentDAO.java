package com.jpa.dao;

import java.util.List;

import com.jpa.entity.AccountAssignment;

public interface IAccountAssignmentDAO {
	public List<AccountAssignment> getAccountAssignments();
	public AccountAssignment getAccountAssignment(int id);
	public List<AccountAssignment> getAccountAssignmentsByCustomerId(int customerId);
	public List<AccountAssignment> getAccountAssignmentsByAccountId(int accountId);
	public void addAccountAssignment(AccountAssignment accountAssigment);
	public AccountAssignment getAccountAssigment(int customerId, int accountId);
}
