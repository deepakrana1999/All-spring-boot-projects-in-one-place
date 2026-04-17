package com.nt.runner;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.controller.PayrollMgmtOperationController;
import com.nt.model.Employee;

@Component("runner")
public class MiniProjectTestRunner implements CommandLineRunner {

	@Autowired
	PayrollMgmtOperationController controller;
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("MiniProjectTestRunner.run()");
		Scanner sc=new Scanner(System.in);
		//get Controller Spring bean class obj ref
		
		
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
		
		sc.close();
		
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


