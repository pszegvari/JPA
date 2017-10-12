package com.jpa.dao;

import java.util.List;

import com.jpa.entity.Customer;

public interface ICustomerDAO {
	
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int id);
	public Customer getCustomerByNames(String firstName, String lastName);
	public boolean existsCustomer(String firstName, String lastName);
	public void addCustomer(Customer customer);

}
