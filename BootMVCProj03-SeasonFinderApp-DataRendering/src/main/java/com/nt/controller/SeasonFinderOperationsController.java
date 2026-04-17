//Controller class
package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nt.service.ISeasonFinderMgmtService;

@Controller
public class SeasonFinderOperationsController {
    @Autowired 
	private ISeasonFinderMgmtService service;
    @RequestMapping("/")
    public String showHomePage()
    {
    	System.out.println("SeasonFinderOperationsController.showHomePage()");
    	return  "welcome";//LVN 
    }
    
    
    @RequestMapping("/season")
    public String ShowSeason(Map<String,Object> map) 
    {
    	//use service
    	String msg=service.findSeason();
    	//keep the result in model attribute
    	map.put("resultMsg", msg);
    	return "show_result";
    }
    

    //one hander method can be mapped with multiple request paths
    //if any data is given with out annotation param name then thet data goes to param showes name is "value"
	/*@RequestMapping({"/report1","/report2","/retort3"})
	public String ShowReport(Map<String,Object> map) 
	{
		//use service
		String msg=service.findSeason();
		//keep the result in model attribute
		map.put("resultMsg", msg);
		return "show_result";
	}*/
    
    
    
  // if we place  multiple request path on the same handler method having both GET and POST modes then the first request path will be taken and other request paths will be ignored
    
  //in @RquestMapping annotaion no mode is spesified default mode is GET
    //GET mode request we can use by taking url of  browser addres bar ,by taking hiper link , by designing form page by taking method as GET 
    //@RequestMapping(value="/report1",method= RequestMethod.GET)
    @GetMapping("/report1")
    @PostMapping("/retort1")
    public String ShowReport1() 
    {
     System.out.println("SeasonFinderOperationsController.ShowReport1()(GET)");
    	
    	return "show_result1";
    }
    
    //POST mode request we can use Only taking form page with POST method
    //@RequestMapping(value="/report1",method = RequestMethod.POST)
    @PostMapping("/report1")
    public String ShowReport2() 
    {
    	System.out.println("SeasonFinderOperationsController.ShowReport2()(POST)");
    	return "show_result2";
    }
    
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
