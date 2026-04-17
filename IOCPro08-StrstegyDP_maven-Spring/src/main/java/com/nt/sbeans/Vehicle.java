package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public final class Vehicle {
   @Autowired
   @Qualifier("dEngine")
	private IEngine engine;
   
   public Vehicle() 
   {
	   System.out.println(" Vehicle class ::0 param constructer");
   }
   
   //b-method
   public void jounery(String from,String to) 
   {
	   engine.startEngine();
	   System.out.println(from);
	   engine.stopEngine();
	   System.out.println(to);
	   
   }
}
