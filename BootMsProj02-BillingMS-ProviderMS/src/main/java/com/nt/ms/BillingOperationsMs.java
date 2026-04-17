package com.nt.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillingOperationsMs {

	@Value("${spring.application.instance-id}")
	private String instanceid;
	@Value("${server.port}")
	private Integer port;
	@GetMapping("/bill")
	public ResponseEntity<String> doBilling()
	{
		//generate billAmt
		long billamt=new Random().nextLong(1000000);
		/*try 
		{
			Thread.sleep(10000);
		 }
		catch(Exception e) 
		{
			e.printStackTrace();
		}*/
		//return ResponseEntity object
		return new ResponseEntity<String>("Bill Amount::"+billamt+"...."+instanceid+"...."+port,HttpStatus.OK);
	}
}
