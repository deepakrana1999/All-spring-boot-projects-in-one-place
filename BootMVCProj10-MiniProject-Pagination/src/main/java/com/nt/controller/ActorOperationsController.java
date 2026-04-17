package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Actor;
import com.nt.service.IActorMgmtService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ActorOperationsController {
	@Autowired
	private IActorMgmtService actorService;
	
	
    //HOME PAGE SHOWING
//========================
	@GetMapping("/")
	public String showHomePage() 
	{
		return"welcome";
	}
	
	//SELECT OPETION
//===========================
	@GetMapping("/report") //(Get)
	public String showReport(Map<String,Object>map) 
	{
		//use service 
		List<Actor> list=actorService.showAllActors();
		//keep the result in model attribute
		map.put("listActors", list);
		//return LVN
		return "show_report";
	}
	
	
	
}
















