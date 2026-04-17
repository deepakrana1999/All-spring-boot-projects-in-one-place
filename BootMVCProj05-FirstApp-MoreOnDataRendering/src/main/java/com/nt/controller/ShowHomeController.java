//ShowHomeController.java
package com.nt.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.model.Customer;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/app")
public class ShowHomeController {

	@GetMapping("/report")
	public String showReort(Map<String,Object> map) 
	{
		
		//add model Attribute (arrays and collections)
		/*map.put("nickNames",new String[] {"king","empirer","raja","maharaja"});
		map.put("friends",List.of("srinibas","dhanush","rama","sudheer"));
		map.put("phones",Set.of(9999999L,8888888L,77777777L,66666666L) );
		map.put("idDetails",Map.of("aadhar",454545,"panNo",5454545,"voterid",4554554));*/
		
		
		//add model attributes (Model class object)
		Customer cust1=new Customer(1001,"raja","hyd",89000.0);
		Customer cust2=new Customer(1002,"rajesh","vizag",19000.0);
		Customer cust3=new Customer(1003,"ramesh","usa",29000.0);
		List<Customer> list=List.of(cust1,cust2,cust3);
		map.put("custList1",list);
		return "result";
	}
	
	}//end showHomeController 
	
	   

