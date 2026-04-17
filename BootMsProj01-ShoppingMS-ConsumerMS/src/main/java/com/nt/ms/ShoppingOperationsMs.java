package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillingMsClientComp;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingOperationsMs {
	@Autowired
	private BillingMsClientComp client;

	@GetMapping("/purchase")
	public ResponseEntity<String> doshoping()
	{
		String msg="Shirt, Trouser items are purchased";
		//invock Target MS endPoint through client comp
		ResponseEntity<String> resp=client.invockDoBilling();
		//generate the final resullt
		String result=msg+"...."+resp.getBody();
		//return ResponseEntity objcet
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
