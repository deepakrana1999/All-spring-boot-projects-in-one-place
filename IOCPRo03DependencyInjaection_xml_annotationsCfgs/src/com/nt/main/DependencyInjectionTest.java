package com.nt.main;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.nt.sbeans.WishMessageGenerator;
public class DependencyInjectionTest {

	public static void main(String[] args) {
		//create IOC container
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		//get Target spring Bean class object ref from the IOCcontainer
		Object obj=ctx.getBean("wmg");
		//type cast
		WishMessageGenerator generator=(WishMessageGenerator)obj;
	    System.out.println("Geather target spring bean class object ref");
	    //invoke the b.method
	    
	    String result=generator.generateWishMessage("Deepak");
	    System.out.println(result);
	    //close the Ioc Container
	    ctx.close();
	    System.out.println("DependencyInjectionTest.main()(end)");
	    

	}

}
