package com.jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.entity.Address;

@Service
public interface IAddressService {
	
	public List<Address> getAllAddresses();
	public Address getAddress(int id);
	public boolean addAddress(Address address);
	public int addAddress(Address[] addressArray);

}
