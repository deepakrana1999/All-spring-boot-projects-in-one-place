package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student-api")
public class StudentOperationsController {

	/*	@GetMapping("/report/{sno}/{sname}/{sadd}")
		public ResponseEntity<String> showStudentData(@PathVariable("sno") int no,
				                                      @PathVariable("sname") String name,
				                                      @PathVariable String sadd)
		{
			System.out.println("path varibale values::"+no+"..."+name+"..."+sadd);
			return new ResponseEntity<String>("path variable values::"+no+"..."+name+"..."+sadd,HttpStatus.OK);
		}*/
	
	/*	@GetMapping({"/report/{sno}/{sname}/{sadd}","/report/{sno}/{sname}","/report/{sno}"})
		public ResponseEntity<String> showStudentData(@PathVariable(name="sno",required=false) int no,
				                                      @PathVariable(name="sname",required=false) String name,
				                                      @PathVariable(required=false) String sadd)
		{
			System.out.println("path varibale values::"+no+"..."+name+"..."+sadd);
			return new ResponseEntity<String>("path variable values::"+no+"..."+name+"..."+sadd,HttpStatus.OK);
		}*/
	
	/*	@GetMapping({"/report/{sno}/{sname}/{sadd}","/report/{sno}/{sname}","/report/{sno}","/report"})
		public ResponseEntity<String> showStudentData(@PathVariable(name="sno",required=false) Integer no,
				                                      @PathVariable(name="sname",required=false) String name,
				                                      @PathVariable(required=false) String sadd)
		{
			System.out.println("path varibale values::"+no+"..."+name+"..."+sadd);
			return new ResponseEntity<String>("path variable values::"+no+"..."+name+"..."+sadd,HttpStatus.OK);
		}*/
	
	
	
	//if end point method haveing same paths then which method having more static path this methord get more priority for exicution
	@GetMapping("/report/no/name")
	public ResponseEntity<String> fetchData1(@PathVariable(name="no",required=false) Integer no,
			                                      @PathVariable(name="name",required=false) String name)
	{
		System.out.println("path varibale values::"+no+"..."+name);
		return new ResponseEntity<String>("path variable values::"+no+"..."+name,HttpStatus.OK);
	}
	
	@GetMapping("/report/no/{name}")
	public ResponseEntity<String> fetchData2(@PathVariable(name="no",required=false) Integer no,
			                                      @PathVariable(name="name",required=false) String name)
	{
		System.out.println("path varibale values::"+no+"..."+name);
		return new ResponseEntity<String>("path variable values::"+no+"..."+name,HttpStatus.OK);
	}
	
	@GetMapping("/report/{no}/{name}")
	public ResponseEntity<String> fetchData3(@PathVariable(name="no",required=false) Integer no,
			                                      @PathVariable(name="name",required=false) String name)
	{
		System.out.println("path varibale values::"+no+"..."+name);
		return new ResponseEntity<String>("path variable values::"+no+"..."+name,HttpStatus.OK);
	}
}
