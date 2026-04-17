package com.nt.comp;

import java.util.Arrays;
import java.util.Random;

public final class Flipkart {
   private ICourier courier;
   
   public void setCourier(ICourier courier) 
   {
	   System.out.println("Flipkart.setCourier()");
	   this.courier=courier;
   }
   
   //B-method
   public String shooping(String items[],double prices[]) 
   {
	   //calculate bill amount
	   double billAmount=0.0;
	   for(double p:prices) 
	   {
		   billAmount=billAmount+p;
	   }
	   //generate the order id(random number as the order)
	   int oid=new Random().nextInt(1000);
	   //delever the product suing courier
	   String msg=courier.deliver(oid);
	   
	   return Arrays.toString(items)+"items with billAmount :::"+billAmount+"....."+msg;
   } 
}
