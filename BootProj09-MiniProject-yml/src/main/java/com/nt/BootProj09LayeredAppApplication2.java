package com.nt;


import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import com.nt.controller.PayrollMgmtOperationController;
import com.nt.model.Employee;

@SpringBootApplication

public class BootProj09LayeredAppApplication2 {

	public static void main(String[] args) {
		//get access to IOC Container
		try
		(ConfigurableApplicationContext ctx = SpringApplication.run(BootProj09LayeredAppApplication2.class, args);Scanner sc=new Scanner(System.in))
		{
		//get Controller Spring bean class obj ref
		PayrollMgmtOperationController controller=ctx.getBean("payroll-controller",PayrollMgmtOperationController.class);
		
		System.out.println("Enter NAME::");
		String name=sc.next();
		
		System.out.println("Enter JOB::");
		String job=sc.next();
		
		System.out.println("Enter MGR::");
		int mgr=sc.nextInt();
		
		System.out.println("Enter HIREDATE(DD-MON-YY)::");
		String hDate=sc.next();
		
		System.out.println("Enter SALARY::");
		double sal=sc.nextDouble();
		
		System.out.println("Enter COMMISION::");
		double comm=sc.nextDouble();
		
		System.out.println("Enter DEPARTMENT NO::");
		int deptNo=sc.nextInt();
		
		//create employee class object
		Employee emp=new Employee();
		emp.setEName(name);emp.setJob(job);emp.setMgr(mgr);
		emp.setHireDate(hDate);emp.setSal(sal);emp.setComm(comm);
		emp.setDeptNo(deptNo);
		
		try 
		{
			String msg=controller.appointEmployee(emp);
			System.out.println(msg);
				
		}
		catch(Exception e) 
		{
			System.out.println("Internal problem"+e.getMessage());
		e.printStackTrace();	
		}
		}
	}

}
