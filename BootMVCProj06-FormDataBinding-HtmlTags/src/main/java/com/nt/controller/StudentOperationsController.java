//StudentOperationController.java
package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;


@Controller 
public class StudentOperationsController {
     
	@GetMapping("/")
	public String showHomePage() //for home page
	{
		//return LVN
		return "welcome";
	}
	
	
	@GetMapping("/register")
	public String showStydentFormPage() {//for lunching form page
		//return LVN
		return "stud_register_form";
	}
	
	
	@PostMapping("/register")
	public String registerStudent(Map<String,Object> map,
			                       @ModelAttribute("stud") Student st) 
	{
		System.out.println("Model class obj data::"+st);
		//write b.logic
		String result=null;
		if(st.getAvg()<35)
			result="fail";
		else 
			result="pass";
		//keep the result into model atrribute (shared memory)
		map.put("resultMsg", result);
		//return LVN
		return "show_result";
	}
}
