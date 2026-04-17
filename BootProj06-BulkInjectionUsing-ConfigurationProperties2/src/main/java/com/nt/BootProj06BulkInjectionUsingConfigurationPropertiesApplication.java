package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

import com.nt.sbeans.Company;
import com.nt.sbeans.PersonDetails;

@SpringBootApplication
//@PropertySource("com/nt/commens/info.proterties")
public class BootProj06BulkInjectionUsingConfigurationPropertiesApplication {

	public static void main(String[] args) {
		//Access the ioc container
	ApplicationContext ctx	=SpringApplication.run(BootProj06BulkInjectionUsingConfigurationPropertiesApplication.class, args);
	  //Access the spring bean class object
	  PersonDetails details=ctx.getBean("pDetails",PersonDetails.class);
	  //display data
	  System.out.println("Data is::"+details);
	  Company c=details.getComp();
	  c.setName("rahul");
	  System.out.println("Data is::"+details.getComp());
	  
	  //close the IOC  container
	  ((ConfigurableApplicationContext) ctx).close();
	  
	}

}
