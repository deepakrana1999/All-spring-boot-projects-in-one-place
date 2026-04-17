//ShowHomeController.java
package com.nt.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class ShowHomeController {
	/* @RequestMapping("/home")
		public String showHomePage(Map<String,Object> map) {
		 System.out.println("ShowHomeController.showHomePage():: Shared Memory obj class name::"+map.getClass());
		 //add attributs (Model attribute) to shared memory
		 map.put("attr1","val1");
		 map.put("attr2","val2");
		 //return LVN
			return "welcome";
		}*/
	
	
	
	/* @RequestMapping("/home")
		public String showHomePage(Model model) {
		 System.out.println("ShowHomeController.showHomePage():: Shared Memory obj class name::"+model.getClass());
		 //add attributs (Model attribute) to shared memory
		 model.addAttribute("attr1","val1");
		 model.addAttribute("attr2","val2");
		 //return LVN
			return "welcome";
		}*/
	
	
	
	/* @RequestMapping("/home")
		public String showHomePage(ModelMap model) {
		 System.out.println("ShowHomeController.showHomePage():: Shared Memory obj class name::"+model.getClass());
		 //add attributs (Model attribute) to shared memory
		 model.addAttribute("attr1","val1");
		 model.put("age",new Random().nextInt(99));
		 //return LVN
			return "welcome";
		}*/
	
	
	
	/*	 @RequestMapping("/home")
			public String showHomePage(ExtendedModelMap model) {
			 System.out.println("ShowHomeController.showHomePage():: Shared Memory obj class name::"+model.getClass());
			 //add attributs (Model attribute) to shared memory
			 model.addAttribute("attr1","val1");
			 model.put("age",new Random().nextInt(99));
			 //return LVN
				return "welcome";
			}*/
	
	
	
	/*
	 @RequestMapping("/home")
		public String showHomePage(BindingAwareModelMap model) {
		 System.out.println("ShowHomeController.showHomePage():: Shared Memory obj class name::"+model.getClass());
		 //add attributs (Model attribute) to shared memory
		 model.addAttribute("attr1","val1");
		 model.put("age",new Random().nextInt(99));
		 //return LVN
			return "welcome";
		}*/
	
	
	
	
	// one legacy approach is ModelAndView which is not recomonded to use for knowedge sake
	/*@RequestMapping("/home")
	public ModelAndView showHomePage() 
	{
		//create SharedMemory Explicitly
		ModelAndView mav=new ModelAndView();
		//add model attributes
		mav.addObject("attr1","val1");
		mav.addObject("age",new Random().nextInt(100));
		//add LVN
		mav.setViewName("welcome");
		return mav;
	}*/
	 
	
	
	
	/*	@RequestMapping("/home")
		public Model showHomePage()//Sence LVN is  returnd ,the request path itself becomes LVN 
		{
			//create SharedMemory Explicitly
			Model model=new BindingAwareModelMap();
			//add model attributes
			model.addAttribute("attr1","val1");
			model.addAttribute("age",new Random().nextInt(1000 ));
			
			return model;
		}*/
	
	
	
	
	/*	@RequestMapping("/home")
		public Map<String,Object> showHomePage()//Sence LVN is  returnd ,the request path itself becomes LVN 
		{
			//create SharedMemory Explicitly
			Map<String,Object> map=new HashMap();
			//add model attributes
			map.put("attr1","val1");
			map.put("age",new Random().nextInt(1000 ));
			
			return map;
		}*/
	
	
	
	
	//if the return type of Handler method is void then default LVN (request path of handeler method) will be return
	/*	@RequestMapping("/home")
		public void showHomePage(Map<String,Object> map)//Sence LVN is  returnd ,the request path itself becomes LVN 
		{
			//add model attributes
			map.put("attr1","val1");
			map.put("age",new Random().nextInt(1000 ));	
		}*/
	
	
	
	
	//if we return null then request path of the handler method will be the LVN
	/*	@RequestMapping("/home")
		public String showHomePage(Map<String,Object> map)//Sence LVN is  returnd ,the request path itself becomes LVN 
		{
			//add model attributes
			map.put("attr1","val1");
			map.put("age",new Random().nextInt(1000 ));
			
			return null;
		}*/
	
	
	
	
	//In forword request handler mathord chaining both source handler methord and destination hendler methord use same request and responce object  
	//so responce handler method can pass model attribute/request attribute to destination handler methrod
	//source handler method	
	/*	@RequestMapping("/home")
			public String showHomePage(Map<String,Object> map,HttpServletRequest req)//Sence LVN is  returnd ,the request path itself becomes LVN 
			{
				System.out.println("ShowHomeController.showHomePage()");
			//request attribute
				req.setAttribute("sysDate", new Date());
				
				return "forward:report";
			}
		//Destination handler method
			@RequestMapping("/report")
			public String showReport(Map<String,Object> map,HttpServletRequest req) 
			{
				System.out.println("ShowHomeController.showReport()");
				map.put("attr1","val1");
				map.put("age",new Random().nextInt(1000));
				
				System.out.println("request attribute value ::"+req.getAttribute("sysDate"));
				return "show_report";
			}*/
	   
	
	
	//In redirect handler methord chaining, source handler methord and destination handler methord do not use same requst and responce object
	//if source handler method  want to pass the request/Model attribute to the destination handler method we have to append query string to the url redirect path.
	/*@RequestMapping("/home")
	public String showHomePage(Map<String,Object> map,HttpServletRequest req)//Sence LVN is  returnd ,the request path itself becomes LVN 
	{
		System.out.println("ShowHomeController.showHomePage()");
	//request attribute
		req.setAttribute("sysDate", new Date());
		
		return "redirect:report";
	}
	//Destination handler method
	@RequestMapping("/report")
	public String showReport(Map<String,Object> map,HttpServletRequest req) 
	{
		System.out.println("ShowHomeController.showReport()");
		map.put("attr1","val1");
		map.put("age",new Random().nextInt(1000));
		
		System.out.println("request attribute value ::"+req.getAttribute("sysDate"));
		return "show_report";
	} */
	
	
	
	//here source ahndler method and destination handler methord are not using same request and responce object
	//if source handler method  want to pass the request/Model attribute to the destination handler method we have to append query string to the url redirect path.
	/*	@RequestMapping("/home")
		public String showHomePage(Map<String,Object> map)//Sence LVN is  returnd ,the request path itself becomes LVN 
		{
			System.out.println("ShowHomeController.showHomePage()");
	
			return "redirect:report?sysDate="+new Date();
		}
		//Destination handler method
		@RequestMapping("/report")
		public String showReport(Map<String,Object> map,HttpServletRequest req) 
		{
			System.out.println("ShowHomeController.showReport()");
			map.put("attr1","val1");
			map.put("age",new Random().nextInt(1000));
			System.out.println(" Additional req param value ::"+ req.getParameter("sysDate"));
			return "show_report";
		}*/ 
	
	
	
	// The EL code kept in jsp page can read and display given attribute values by searching in multiput scoups in following order
	//a) page scope  b) request scope  c) session scope  d) application scope
	//note=> Model attribute scope is request scope
	/*	@RequestMapping("/home")
		public String showHomePage(Map<String,Object> map,HttpServletRequest req,HttpSession ses) 
		{
			System.out.println("ShowHomeController.showReport()");
			//add model attibutes
			map.put("attr1","val1");
			map.put("age",new Random().nextInt(1000));
	    req.setAttribute("sysDate_className",new Date().getClass());
	    ses.setAttribute("sysDate",new Date());
			
			return "welcome";
		} */
	
	
	
	/*	@Autowired
		private ServletContext sc;
		@Autowired
		private ServletConfig cg;
		
		@RequestMapping("/home")
		public String showHomePage(Map<String,Object> map) 
		{
			System.out.println("ShowHomeController.showReport()");
			//add model attibutes
			map.put("attr1","val1");
			map.put("age",new Random().nextInt(1000));
	    
			sc.setAttribute("email","raja@rani.com");
			System.out.println("Servletcontext obj class::"+sc.getClass());
			System.out.println("ServletConfig object class"+cg.getClass());
			return "welcome";
		}*/
	
	
	
	//wethout involveing ViewResulver, view component if we want to send out put to the browser then we have to do below approach
	@RequestMapping("/home")
	public void showHomePage(HttpServletResponse res)  throws Exception
	{
	  //get PrintWriter  object
	PrintWriter pw=res.getWriter();	
	//make the responce as the downlodable file
	res.setHeader("Content-Disposition","attachment;fileName=abc.txt");
	//write message to browser directly
	pw.println("<b>hellow how r u</b>");
	
	}
	}//end showHomeController 
	
	   

/* @RequestMapping("/")
	public String showHomePage() {
	 //return LVN
		return "welcome";
	}
}*/
