package com.nt.ms;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nt.client.IBillingMsClientComp;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingOperationsMs {

   
	@Autowired
	private IBillingMsClientComp client;

	@GetMapping("/purchase")
	public ResponseEntity<String> doshoping()
	{
		System.out.println("client comp proxy class name::"+client.getClass());
		System.out.println("Proxy class implemented interfaces::"+Arrays.toString(client.getClass().getInterfaces()));
		System.out.println("Proxy class methods are::"+Arrays.toString(client.getClass().getDeclaredMethods()));
		String msg="Shirt, Trouser items are purchased";
		//invoke Target MS endPoint through client component
		ResponseEntity<String> resp=client.invockDoBilling();
		//generate the final result
		String result=msg+"...."+resp.getBody();
		//return ResponseEntity object
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
