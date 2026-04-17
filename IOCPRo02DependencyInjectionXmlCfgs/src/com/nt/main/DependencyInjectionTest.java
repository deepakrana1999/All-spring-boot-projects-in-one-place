package com.nt.main;
import com.nt.sbeans.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class DependencyInjectionTest {

	public static void main(String[] args){
		
ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	//Object obj=ctx.getBean("wng");
	WishMessageGenerator generate=(WishMessageGenerator)ctx.getBean("wmg");
	String result=generate.generateWishMessgae("raju");
	System.out.println(result);
	ctx.close();
	}

}
