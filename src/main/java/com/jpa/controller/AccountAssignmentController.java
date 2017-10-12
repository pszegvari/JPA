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

import com.jpa.entity.AccountAssignment;
import com.jpa.service.AccountAssignmentService;

@Controller
@RequestMapping("/")
public class AccountAssignmentController {
	
	@Autowired
	private AccountAssignmentService aaService;
	
	@GetMapping("accountAssignments")
	public ResponseEntity<List<AccountAssignment>> getAllAssignment()  {
		return new ResponseEntity<List<AccountAssignment>>(aaService.getAccountAssignments(), HttpStatus.OK);
	}
	
	@GetMapping("accountAssignment/{id}")
	public ResponseEntity<AccountAssignment> getAssigment(@PathVariable("id") int id) {
		return new ResponseEntity<AccountAssignment>(aaService.getAccountAssignment(id), HttpStatus.OK);
	}
	
	@GetMapping("accountAssignment/{customerId}")
	public ResponseEntity<List<AccountAssignment>> getAssigmentByCustomerId(@PathVariable("customerId") int customerId) {
		return new ResponseEntity<List<AccountAssignment>>(aaService.getAccountAssignmentsByCustomerId(customerId), HttpStatus.OK);
	}
	
	@GetMapping("accountAssignment/{accountId}")
	public ResponseEntity<List<AccountAssignment>> getAssigmentByAccountId(@PathVariable("accountId") int accountId) {
		return new ResponseEntity<List<AccountAssignment>>(aaService.getAccountAssignmentsByAccountId(accountId), HttpStatus.OK);
	}
	
	@PostMapping("accountAssignment")
	public ResponseEntity<Void> addAssignment(@RequestBody AccountAssignment accountAssignment, UriComponentsBuilder builder) {
		if (!aaService.addAccountAssignment(accountAssignment)) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/accountAssignment/{id}").buildAndExpand(Integer.valueOf(accountAssignment.getId())).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@PostMapping("accountAssignments")
	public ResponseEntity<Void> addAssignment(@RequestBody AccountAssignment[] assignmentArray) {
		aaService.addAccountAssignment(assignmentArray);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
