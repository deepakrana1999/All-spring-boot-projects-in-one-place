package com.nt.sbeans;
   import java.time.LocalTime;
public class WishMessageGenerator {
     private LocalTime lt;

	public WishMessageGenerator(LocalTime lt) {
		super();
		this.lt = lt;
		System.out.println("WishMessageGenerator.WishMessageGenerator()");
	}
	//b.method
	public String generateWishMessgae(String user) {
		System.out.println("WishMessageGenerator.generateWishMessgae()");
		int hour=lt.getHour();
		if(hour<12)
		return "Good Morning  "+user;
		else if(hour<16)
			return "Good Afternoon  "+user;
		else if(hour<20) 
		return "Good evening  "+user ;
		else 
			return "GoodNight  "+user;
	}
     
}
