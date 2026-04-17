package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public  final class  EmpoyeeMgmtServiceImpl implements IEmployeeMgmtService {
    @Autowired
	private IEmployeeDAO empDAO;
    
    
    public EmpoyeeMgmtServiceImpl() {
    	System.out.println("EmpoyeeMgmtServiceImpl::0 param constructer");
	}
	@Override
    public List<Employee> fetchEmployeeByJobs(String job1,String job2,String job3)throws Exception 
	{

		System.out.println("EmpoyeeMgmtServiceImpl.fetchEmployeeByJobs()");
		//convert the jobs (input )to upper case letter
	     job1=job1.toUpperCase();
	     job2=job2.toUpperCase();
	     job3=job3.toUpperCase();
	     //use DAO
	     List<Employee> list=empDAO.showEmployeeByJobs(job1, job2, job3);
	     //calculate gross Salary and Net Salary(b -logic)
	     list.forEach(emp->{
	    	 emp.setGrossSalary(emp.getSal()+(emp.getSal()*0.4));
	    	 emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.15));
	    	 });
		return list;
	}
	@Override
	public String registerEmployee(Employee emp) throws Exception {
		System.out.println("EmpoyeeMgmtServiceImpl.registerEmployee()");
		int count=empDAO.registerEmployee(emp); 
		return count==0?"Employee not regester":"Employee is registered";
	}

}
