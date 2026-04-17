package com.nt.controller;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {
     
	@GetMapping("/")
	public String showHomePage(Map<String,Object>map) 
	{
		//add model attributes
		// i am hard cording here to understand if we need you can collrct from database
		map.put("sysDate",new Date());
		map.put("price",new Random(20000).nextInt());
		map.put("percentage",12);
		map.put("distance",454454356);
		
		//return LVN
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showCustomerRegistrationFormPage(@ModelAttribute("cust") Customer customer) 
	{
		//return LVN
		return "customer_register_form";
	}
	
	
}
