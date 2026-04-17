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



import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ShowHomeController {
   
	@GetMapping("/report")
	public String ShowReport(Map<String,Object> map) 
	{
		        //add model attributes(arrays and collections)
				map.put("nickNames",new String[] {"king","empirer","raja","maharaja"});
				map.put("friends",List.of("srinivas","dhanus","rama","suresh"));
				map.put("phones",Set.of(99999999L,77777777L,8888888888L,66666666L));
				map.put("idDetails",Map.of("aadhar",454545,"panNo",5454545,"voterid",4545454));
				
		
		
				/*//add model attributea (Model class obj)
				Customer cust=new Customer(1001,"raja","hyd",89000.0);
				map.put("custData", cust);*/
		
		
		
		return "result";
	}
}
