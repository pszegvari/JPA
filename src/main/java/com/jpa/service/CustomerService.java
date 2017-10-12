package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.dao.CustomerDAO;
import com.jpa.entity.Customer;

@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	public Customer getCustomer(int customerId) {
		return customerDAO.getCustomer(customerId);
	}

	@Override
	public Customer getCustomerByNames(String firstName, String lastName) {
		return customerDAO.getCustomerByNames(firstName, lastName);
	}

	@Override
	public synchronized boolean addCustomer(Customer customer) {
		if (customerDAO.existsCustomer(customer.getFirstName(), customer.getLastName())) {
			return false;
		}
		customerDAO.addCustomer(customer);
		return true;
	}

	@Override
	public int addCustomers(Customer[] customerArray) {
		int counter = 0;
		for (Customer cust : customerArray) {
			if (addCustomer(cust)) {
				counter++;
			}
		}
		return counter;
	}

}