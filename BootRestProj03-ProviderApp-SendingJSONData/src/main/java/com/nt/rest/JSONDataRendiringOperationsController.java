package com.nt.rest;


import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;
import com.nt.model.Customer;

@RestController
@RequestMapping("/json-api")
public class JSONDataRendiringOperationsController {
     
	@GetMapping("/customer")
	public ResponseEntity<Customer> showCustomerData()
	{
		Customer cust=new Customer(1001,"raja","hyd",8000.04);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
	
	@GetMapping("/actor")
	public ResponseEntity<Actor> showActorData()
	{
		Actor actor=new Actor(1001,"Sharuk","mumbai",900000.0,new String[] {"red","green"},
				              List.of("salam","sharuk"),Set.of(9999999L,8888888L),Map.of("adhar",6565656,"voter",66665555),new Customer(112,"raja","hyd",566566.06));
		
		return new ResponseEntity<Actor>(actor,HttpStatus.OK);
	}
	
	@GetMapping("/allcustomer")
	public ResponseEntity<List<Customer>> showCustomersData()
	{
		Customer cust1=new Customer(1001,"raja","hyd",8999.9);
		Customer cust2=new Customer(1001,"raja","hyd",8999.9);
		Customer cust3=new Customer(1001,"raja","hyd",8999.9);
		Customer cust4=new Customer(1001,"raja","hyd",8999.9);
		
		List<Customer> list=List.of(cust1,cust2,cust3,cust4);
		
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	} 
}




















