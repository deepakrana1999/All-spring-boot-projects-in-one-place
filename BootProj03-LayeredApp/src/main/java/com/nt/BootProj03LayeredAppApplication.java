package com.nt;

import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.controller.PayrollMgmtOperationController;
import com.nt.model.Employee;

//exclude is used for a class not eligible for autoconfiguration

@SpringBootApplication(exclude= {JdbcTemplateAutoConfiguration.class})
@ImportResource("com/nt/confgs/ApplicationContext.xml")
public class BootProj03LayeredAppApplication {

	public static void main(String[] args) {
		//get access to IOC Container
		//this run methord internaly use three annotions
		//@Configutation
		//@EnableAutoConfiguration
		//@ComponentScan
		try
		(ConfigurableApplicationContext ctx = SpringApplication.run(BootProj03LayeredAppApplication.class, args);Scanner sc=new Scanner(System.in))
		{
		//get Controller Spring bean class obj ref
		PayrollMgmtOperationController controller=ctx.getBean("payroll-controller",PayrollMgmtOperationController.class);
		
		System.out.println("Enter job1::");
		String job1=sc.next();
		
		System.out.println("Enter job2::");
		String job2=sc.next();
		
		System.out.println("Enter job3::");
		String job3=sc.next();
		
		//invock the b.methods
		try 
		{
			List<Employee> list=controller.showEmployeesByJobs(job1, job2, job3);
			System.out.println("Employee belonging to"+job1+" "+job2+" "+job3+"are");
			
			list.forEach(emp->{
			System.out.println(emp);	
			});
		}
		catch(Exception e) 
		{
			System.out.println("Internal problem"+e.getMessage());
		e.printStackTrace();	
		}
		}
	}

}
