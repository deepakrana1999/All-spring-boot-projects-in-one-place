package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller("payroll-controller")
public class PayrollMgmtOperationController {
	@Autowired
	private IEmployeeMgmtService empService;
    
	//show employee follord by jobs
	public List<Employee> showEmployeesByJobs(String job1,String job2,String job3 )throws Exception
    {
    	//use service
    	List<Employee> list=empService.fetchEmployeeByJobs(job1, job2, job3);
    	return list;
    }
    
	//appointEmployee 
	public String appointEmployee(Employee emp)throws Exception
	{
		//use service
		String msg=empService.registerEmployee(emp);
		return msg;
	}
    
}
