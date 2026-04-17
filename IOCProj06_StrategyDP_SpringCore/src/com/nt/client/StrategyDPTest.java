package com.nt.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.Flipkart;

public class StrategyDPTest {
	public static void main(String []args) {
   AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
   
   Flipkart fpkt=ctx.getBean("fpkt",Flipkart.class);
   String resultMsg=fpkt.shooping(new String[] {"shirt","trouser"},new double[] {9000.0,5000.0});
   System.out.println(resultMsg);
   ctx.close();
}
}