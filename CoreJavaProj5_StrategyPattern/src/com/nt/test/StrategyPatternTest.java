package com.nt.test;

import com.nt.comp.Flipkart;
import com.nt.factory.FlipkartFacttory;

public class StrategyPatternTest {
   public static void main(String []args) 
   {
	   Flipkart fpkt= FlipkartFacttory.getInstance("dtdc");
	   String resultMessage=fpkt.shooping(new String[] {"shirt","trouser"}, new double []{5000.0,6000.0});
	   System.out.println(resultMessage);
   }
}
