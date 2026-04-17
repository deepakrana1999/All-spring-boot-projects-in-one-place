package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nt.BootRestProj05ConvertingJsonToJavaObjectApplication;
import com.nt.model.Actor;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {

    private final BootRestProj05ConvertingJsonToJavaObjectApplication bootRestProj05ConvertingJsonToJavaObjectApplication;

    CustomerOperationsController(BootRestProj05ConvertingJsonToJavaObjectApplication bootRestProj05ConvertingJsonToJavaObjectApplication) {
        this.bootRestProj05ConvertingJsonToJavaObjectApplication = bootRestProj05ConvertingJsonToJavaObjectApplication;
    }
    
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer cust)
	{
	    System.out.println("Custumer object data::"+cust);
	    return new ResponseEntity<String>(cust.toString(),HttpStatus.OK);
	}
	
	@PostMapping("/register-actor")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor)
	{
		System.out.println("Actore object Data:: "+actor);
		return new ResponseEntity<String>(actor.toString(),HttpStatus.OK);
	}
	
}
