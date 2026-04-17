package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.Appcfg;
import com.nt.sbeans.WishMessageGenerator;

public class DependencyInjection_Test {

	public static void main(String[] args) {
      //create ioc container
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Appcfg.class);
      //get Target Spring bean class object ref
	   WishMessageGenerator generate=(WishMessageGenerator)ctx.getBean("wmg");
	   //invock the B-method
	   String msg=generate.generateWishMessage("deepak");
	   System.out.println(msg);
	   //close the Ioc container
	   ctx.close();
	}

}
