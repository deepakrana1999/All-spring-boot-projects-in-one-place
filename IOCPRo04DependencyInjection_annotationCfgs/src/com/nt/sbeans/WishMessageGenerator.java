package com.nt.sbeans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired  //field Injection
	private LocalTime lt;  //has a property
	@Autowired  //field Injection
	private LocalDate ld;  //has a property
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-param constructer");
	}
	//B-method
	
	public String generateWishMessage(String user) 
	{
		System.out.println("WishMessageGenerator.generateWishMessage()::"+lt+"..."+ld);
		//get current hour of the day
		int hour=lt.getHour();
		if(hour<12)
			return "Good morning:"+user;
		else if(hour<16)
		    return "Good AfterNoon:"+user;
		else if(hour<20)
			return "Good Evening:"+user;
		else 
			return "Good Night"+user;
		
	}
	

}
