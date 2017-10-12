package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.entity.Customer;

@Repository
@Transactional
public class CustomerDAO implements ICustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomers() {
		return entityManager.createQuery("from Customer order by id").getResultList();
	}

	@Override
	public Customer getCustomer(int customerId) {
		return entityManager.find(Customer.class, Integer.valueOf(customerId));
	}

	@Override
	public Customer getCustomerByNames(String firstName, String lastName) {
		return (Customer) entityManager.createQuery("from Customer where firstname = ? and lastname = ?").setParameter(1, firstName).setParameter(2, lastName).getResultList().get(0);
	}

	@Override
	public boolean existsCustomer(String firstName, String lastName) {
		return !entityManager.createQuery("from Customer where firstname = ? and lastname = ?").setParameter(1, firstName).setParameter(2, lastName).getResultList().isEmpty();
	}

	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}
	

	
}
