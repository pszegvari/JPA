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

import com.jpa.entity.Bank;
import com.jpa.service.BankService;

@Controller
@RequestMapping("/")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@GetMapping("banks")
	public ResponseEntity<List<Bank>> getBanks() {
		return new ResponseEntity<List<Bank>>(bankService.getAllBanks(), HttpStatus.OK);
	}
	
	@GetMapping("banks/{id}")
	public ResponseEntity<Bank> getBank(@PathVariable("id") int id) {
		return new ResponseEntity<Bank>(bankService.getBank(id), HttpStatus.OK);
	}
	
	@PostMapping("bank")
	public ResponseEntity<Void> addBank(@RequestBody Bank bank, UriComponentsBuilder builder) {
		if (!bankService.addBank(bank)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("banks/{id}").buildAndExpand(Integer.valueOf(bank.getId())).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@PostMapping("banks")
	public ResponseEntity<Void> addBanks(@RequestBody Bank[] banks) {
		bankService.addBanks(banks);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
