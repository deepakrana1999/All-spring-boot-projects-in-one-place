package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsAPI {
    
	//for select operations
	@GetMapping("/show")
	public ResponseEntity<String> showCustomerData()
	{
		System.out.println("CustomerOperationsAPI.showCustomerData()");
		
		return new ResponseEntity<String>("Show Single Customer Data",HttpStatus.OK);
	}
	
	//for insert Operations
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer()
	{
		System.out.println("CustomerOperationsAPI.registerCustomer()");
		
		return new ResponseEntity<String>("Register the Customer",HttpStatus.OK);
	}
	
	//for update operations
	@PutMapping("/update")
	public ResponseEntity<String> UpdateCustomer()
	{
		System.out.println("CustomerOperationsAPI.UpdateCustomer()");
		return new ResponseEntity<String>("Update Complite Customer Details",HttpStatus.OK);
	}
	
	//for Delete operations
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer()
	{
		System.out.println("CustomerOperationsAPI.deleteCustomer()");
		return new ResponseEntity<String>("Deleting the customer info",HttpStatus.OK);
	}
	
	//for partial update operations
	@PatchMapping("emailUpdate")
	public ResponseEntity<String> upadteCustomerEmail()
	{
		System.out.println("CustomerOperationsAPI.upadteCustomerEmail()");
		return new ResponseEntity<String>("Upadte the Customer Emailid",HttpStatus.OK);
	}
}
