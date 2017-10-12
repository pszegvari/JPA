package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.jpa.entity.Customer;
import com.jpa.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
		return new ResponseEntity<Customer>(customerService.getCustomer(id), HttpStatus.OK);
	}
	
	@PostMapping("customer")
	public ResponseEntity<Void> addCustomer(@RequestBody Customer customer, UriComponentsBuilder builder) {
		if (!customerService.addCustomer(customer)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("customers/{id}").buildAndExpand(Integer.valueOf(customer.getId())).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@PostMapping("customers")
	public ResponseEntity<Void> addCustomers(@RequestBody Customer[] customerArray) {
		customerService.addCustomers(customerArray);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
