package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamOperationsController {
    
	/*	@GetMapping("/process")
		public String process(@RequestParam("sno")int no,@RequestParam("sname") String name) 
		{
			System.out.println("sno="+no+"--------"+"sname"+name);
			return "show_data";
		}*/
	
	
	
	//if request param  names are  matching  with the method parameter names we not requird to write @RequestParam annotation parametr values
	/*	@GetMapping("/process")
		public String process(@RequestParam(required = false,defaultValue="456") Integer sno,@RequestParam(required = false) String sname) 
		{
			System.out.println("sno="+sno+"--------"+"sname="+sname);
			return "show_data";
		}*/
	
	
	/*@GetMapping("/process")
	public String process(@RequestParam(required = false) Integer sno,@RequestParam(required = false) String sname) 
	{
		System.out.println("sno="+sno+"--------"+"sname="+sname);
		return "show_data";
	}*/
	
	
	
	/*	@GetMapping("/process")
		public String process(@RequestParam Integer sno,
				              @RequestParam String sname,
				              @RequestParam(name="sadd") String[] addrs,
				              @RequestParam(name="sadd") List<String> addrsList,
				              @RequestParam (name="sadd")Set<String> addrsSet) 
		{
			System.out.println("sno="+sno+"------"+"sname="+sname+"----"+"addrs"+Arrays.toString(addrs)+"----"+"addrsList"+addrsList+"----"+"addrsSet"+addrsSet);
			return "show_data";
		}*/
	
	
	@GetMapping("/process")
	public String process(@RequestParam Integer sno,
			              @RequestParam String sname,
			              @RequestParam String sadd ) 
	{
		System.out.println("sno="+sno+"------"+sname+"----"+sadd  );
		return "show_data";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class
