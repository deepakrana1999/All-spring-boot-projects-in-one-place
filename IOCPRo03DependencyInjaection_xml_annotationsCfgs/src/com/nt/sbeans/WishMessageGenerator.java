package com.nt.sbeans;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired  //field Injection
   private LocalTime lt;  //HAS-A property
	@Autowired  //field injection
   private LocalDate id;  //Has-A property
	
	//b.method
    public String generateWishMessage(String user) 
    {
    	System.out.println("WishMessageGenerator.generateWishMessage()");
    	//get current hour of the day
    	int hour=lt.getHour();
    	if(hour<12) return "Good Morning:"+user;
    	else if(hour<16) return "Good AfterNoon:"+user;
    	else if(hour<20) return "Good evening:"+user;
    	else return "Good Night:"+user;
    }
}
