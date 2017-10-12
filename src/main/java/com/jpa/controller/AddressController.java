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

import com.jpa.entity.Address;
import com.jpa.service.AddressService;

@Controller
@RequestMapping("/")
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@GetMapping("addresses")
	public ResponseEntity<List<Address>> getAddresses() {
		return new ResponseEntity<List<Address>>(addressService.getAllAddresses(), HttpStatus.OK);
	}
	
	@GetMapping("addresses/{id}")
	public ResponseEntity<Address> getAddress(@PathVariable("id") int id) {
		return new ResponseEntity<Address>(addressService.getAddress(id), HttpStatus.OK);
	}
	
	@PostMapping("address")
	public ResponseEntity<Void> addAddress(@RequestBody Address address, UriComponentsBuilder builder) {
		if (!addressService.addAddress(address)) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("addresses/{id}").buildAndExpand(Integer.valueOf(address.getId())).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@PostMapping("addresses")
	public ResponseEntity<Void> addAddress(@RequestBody Address[] addressArray) {
		addressService.addAddress(addressArray);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
