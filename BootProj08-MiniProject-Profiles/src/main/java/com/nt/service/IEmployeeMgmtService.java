package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
    public List<Employee> fetchEmployeeByJobs(String job1,String job2,String job3)throws Exception;
    public String registerEmployee(Employee emp)throws Exception;
}
