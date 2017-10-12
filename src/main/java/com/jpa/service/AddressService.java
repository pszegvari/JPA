package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.dao.AddressDAO;
import com.jpa.entity.Address;

@Service
public class AddressService implements IAddressService{

	@Autowired
	private AddressDAO addressDao;
	
	@Override
	public List<Address> getAllAddresses() {
		return addressDao.getAllAddresses();
	}

	@Override
	public Address getAddress(int id) {
		return addressDao.getAddress(id);
	}

	@Override
	public synchronized boolean addAddress(Address address) {
		if (addressDao.existsAddress(address.getZipCode(), address.getSettlement(), address.getPublicPlace(), 
				address.getPublicPlaceType(), address.getHouseNumber(), address.getAddressOtherField())) {
			return false;
		}
		addressDao.addAddress(address);
		return true;
	}

	@Override
	public synchronized int addAddress(Address[] addressArray) {
		int counter = 0;
		for (Address adr : addressArray) {
			if (addAddress(adr)) {
				counter++;
			}
		}
		return counter;
	}

}
