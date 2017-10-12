package com.jpa.service;

import java.util.List;

import com.jpa.entity.Customer;

public interface ICustomerService {
	
	public List<Customer> getAllCustomers();
	public Customer getCustomer(int id);
	public Customer getCustomerByNames(String firstName, String lastName);
	public boolean addCustomer(Customer customer);
	public int addCustomers(Customer[] customerArray);

}
