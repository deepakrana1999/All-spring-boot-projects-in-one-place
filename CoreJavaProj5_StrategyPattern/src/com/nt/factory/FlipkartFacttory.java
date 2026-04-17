package com.nt.factory;

import com.nt.comp.BlueDart;
import com.nt.comp.DTDC;
import com.nt.comp.Flipkart;
import com.nt.comp.ICourier;

public class FlipkartFacttory {
  //ststic factory method having factory pattern logic
	
	public static Flipkart getInstance(String courierType) 
	{
		//create Dependent class object
		ICourier courier=null;
		if(courierType.equalsIgnoreCase("dtdc"))
			courier=new DTDC();
		else if(courierType.equalsIgnoreCase("blueDart"))
			courier=new BlueDart();
		else
			throw new IllegalArgumentException();
		
	//create target class object
		Flipkart fpkt=new Flipkart();
		//assign dependent class object to target class obj
		fpkt.setCourier(courier);
		 
		return fpkt;
		}
}
