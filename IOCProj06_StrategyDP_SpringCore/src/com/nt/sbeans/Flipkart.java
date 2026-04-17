package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fpkt")

public final class Flipkart {
	@Autowired
	@Qualifier("bDart")
   private ICourier courier;
   
   public Flipkart() 
   {
	   System.out.println("Flipkart::0-param Constructer");
   }
   
   //b.method
   public String shooping(String items[],double prices[]) 
   {
	   //calculate bill amount
	   double billAmount=0.0;
	   for(double p: prices) 
	   {
		    billAmount=billAmount + p;
	   }
	   //generate order id randomly
	   int oid=new Random().nextInt(1000);
	   String msg=courier.deliver(oid);
	   
	   return Arrays.toString(items)+"are shooped haveing bill amount::"+billAmount+"....>"+msg;
   }
}
