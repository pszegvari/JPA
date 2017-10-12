package com.jpa.utility;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpa.service.AddressService;

public class Utility {
	
	@Autowired
	private static AddressService addressService;
	
	public static boolean addressExistsWithId(int addressId) {
		return addressService.getAddress(addressId) != null;
	}

}
