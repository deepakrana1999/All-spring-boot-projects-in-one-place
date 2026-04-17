package com.nt.main;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.nt.sbeans.WishMessageGenerator;
public class DependencyInjectionTest02 {

	public static void main(String []args) 
	{
		System.out.println("DependencyInjectionTest.main()");
		//create IOC container
       FileSystemXmlApplicationContext ctx= new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
       //get Target spring Bean class object ref from the IOCcontainer
       Object obj=ctx.getBean("wmg");
       //type cast
       WishMessageGenerator generate=(WishMessageGenerator)obj;
       //invock the b.method
       String result=generate.generateWishMessage("Deepak");
       System.out.println(result);
       //close the IOC container
       ctx.close();
       System.out.println("DependencyInjectionTest.main()(end)");
	}
}

