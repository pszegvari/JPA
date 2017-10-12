package com.jpa.dao;

import java.util.List;

import com.jpa.entity.Address;

public interface IAddressDAO {
	public List<Address> getAllAddresses();
	public Address getAddress(int id);
	public void addAddress(Address address);
	public boolean existsAddress(String zipCode, String settlement, String publicplace, String publicplaceType, String houseNumber, String addressOtherField);
}
