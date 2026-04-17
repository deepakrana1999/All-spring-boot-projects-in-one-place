package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
	public String showReport(@PageableDefault(page=0,size=4,sort="aname",direction=Sort.Direction.ASC)Pageable pageable,Map<String,Object>map) 
	{
		//use service 
		Page<Actor> page=actorService.showAllActors(pageable);
		//keep the result in model attribute
		map.put("pageData",page );
		//return LVN
		return "show_report";
	}
	
	
	//SAVE OPERATION
	//=======================
	//form lunching 
	@GetMapping("/register")
	public String showFormPageForRegiasterActor(@ModelAttribute("actor")  Actor actor) 
	{   
		//return LVN (form page)
		return "actor_register_formpage";
	}
	
	
	//registratin page
	/*	@PostMapping("/register")  //problem code
		public String regesterActor(@ModelAttribute("actor") Actor actor,Map<String,Object> map) 
		{   
			//use service
			String msg=actorService.registerActor(actor);
			List<Actor> list=actorService.showAllActors();
			//keep the result in te model attribute
			map.put("listActors", list);
			map.put("resultMsg", msg);
			//return LVN
		return "show_report";	
		}*/
	
	
	/*	@PostMapping("/register")  //solution 1 -impementing PRG Pattern (Post)
		public String regesterActor(@ModelAttribute("actor") Actor actor,Map<String,Object> map) 
		{   
			//use service
			String msg=actorService.registerActor(actor);
			//keep the result in to model attribute
			//here result value will not shown in the browser because bindingAwareModelMap share memory is created requiest scope source handler 
			//method and target handler methord has different request scope respectivily
			map.put("resultMsg", msg);
			//return LVN
		return "redirect:report"; //(Redirect)
		
		//if ur useing "forword:<path>" for the forwording request mode based method chining then source handler method request mode must match with destination handler method request mode
		//return "forword:report";
		}*/
	
	
	
	/*@PostMapping("/register")  //solution 2 -impementing PRG Pattern (Post)
	public String regesterActor(@ModelAttribute("actor") Actor actor,
			                     RedirectAttributes attrs) //RedirectAttributes have redirect scope sharememory it share the  memory source handeler method to destination handler method
	{   
	System.out.println("ActorOperationsController.regesterActor()");
		
		//use service
		String msg=actorService.registerActor(actor);
		//keep the result in to model attribute
		//here result value will not shown in the browser because bindingAwareModelMap share memory is created requiest scope source handler 
		//method and target handler methord has different request scope respectivily
	    attrs.addFlashAttribute("resultMsg", msg);
		//return LVN
	return "redirect:report"; //(Redirect)
	
	//if ur useing "forword:<path>" for the forwording request mode based method chining then source handler method request mode must match with destination handler method request mode
	//return "forword:report";
	}*/
	
	
	@PostMapping("/register")  //solution 3 -impementing PRG Pattern (Post)
	public String regesterActor(@ModelAttribute("actor") Actor actor,
			                     HttpSession sec) //HttpSession Attribubtes are visible for all handler method because scope is session scope.
	{   
	System.out.println("ActorOperationsController.regesterActor()");
		
		//use service
		String msg=actorService.registerActor(actor);
		//keep the result in to model attribute
		//here result value will not shown in the browser because bindingAwareModelMap share memory is created requiest scope source handler 
		//method and target handler methord has different request scope respectivily
	    sec.setAttribute("resultMsg", msg);
		//return LVN
	return "redirect:report"; //(Redirect)
	
	//if ur useing "forword:<path>" for the forwording request mode based method chining then source handler method request mode must match with destination handler method request mode
	//return "forword:report";
	}
	
	
	//EDIT OPERATION
//======================
	@GetMapping("/edit")
	public String editActorFormPage(@ModelAttribute("actor") Actor actor,@RequestParam("no") Integer id) 
	{
		//use service 
		Actor actor1=actorService.fatchActorById(id);
		//copy actor1 object data to actor object (ModelAttribute)
		BeanUtils.copyProperties(actor1, actor);
		//return LVN
		return "actor_edit_form";
	}
	
	@PostMapping("/edit")
	public String editActor(@ModelAttribute("actor") Actor actor,
			                 RedirectAttributes attrs) 
	{
		//use service
		String msg=actorService.editActor(actor);
		//kip the result in flash attribute
		attrs.addFlashAttribute("resultMsg",msg);
		//redirect the request
		return "redirect:report";
	}
	
	//DELETE OPERATION
//=========================
	@GetMapping("/delete")
	public String  removeActorById(@RequestParam("no") int id,Map<String,Object> map) 
	{    
		//use service 
		String msg =actorService.deleteActorById(id);
		//keep the result in the flash attribute
	    map.put("resultMsg", msg);
	return "forward:report";	
	}
	
}
















