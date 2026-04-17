package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actor-api")
public class ActorOperationsController {

	/*@GetMapping("/report")
	public ResponseEntity<String> showActorData(@RequestParam("aid") int id,
			                                    @RequestParam("aname") String name)
	{
		System.out.println("Requestparam values are::"+id+"....."+name);
		return new ResponseEntity<>("request params are::"+id+"..."+name,HttpStatus.OK);
	}
}*/

//if request param parameter name and reuestparam key both are same then we need not write request param parameter name	
	/*@GetMapping("/report")
	public ResponseEntity<String> showActorData(@RequestParam int id,
			                                    @RequestParam String name)
	{
		System.out.println("Requestparam values are::"+id+"....."+name);
		return new ResponseEntity<>("request params are::"+id+"..."+name,HttpStatus.OK);
	}
}*/
	//if we declare required=false in request param parameter then it is optioal the value we can pass
/*	@GetMapping("/report")
	public ResponseEntity<String> showActorData(@RequestParam int id,
			                                    @RequestParam(required=false) String name)
	{
		System.out.println("Requestparam values are::"+id+"....."+name);
		return new ResponseEntity<>("request params are::"+id+"..."+name,HttpStatus.OK);
	}
}*/
	
	//we can set default value
	@GetMapping("/report")
	public ResponseEntity<String> showActorData(@RequestParam int id,
			                                    @RequestParam(required=false,defaultValue="KING") String name)
	{
		System.out.println("Requestparam values are::"+id+"....."+name);
		return new ResponseEntity<>("request params are::"+id+"..."+name,HttpStatus.OK);
	}
}





