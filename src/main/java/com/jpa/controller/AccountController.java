package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.jpa.entity.Account;
import com.jpa.service.AccountService;

@Controller
@RequestMapping("/")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		return new ResponseEntity<List<Account>>(accountService.getAllAccounts(), HttpStatus.OK);
	}
	
	@GetMapping("accounts/{id}")
	public ResponseEntity<Account> getAccount(int id) {
		return new ResponseEntity<Account>(accountService.getAccount(id), HttpStatus.OK);
	}
	
	@PostMapping("account")
	public ResponseEntity<Void> addAccount(@RequestBody Account account, UriComponentsBuilder builder) {
		if (!accountService.addAccount(account)) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("accounts/{id}").buildAndExpand(Integer.valueOf(account.getId())).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@PostMapping("accounts")
	public ResponseEntity<Void> addAccount(@RequestBody Account[] accountArray) {
		accountService.addAccount(accountArray);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
