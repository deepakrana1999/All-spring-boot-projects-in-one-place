package com.nt.dao;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeDAO {
    public List<Employee> showEmployeeByJobs(String job1,String job2,String job3)throws Exception ;
    public int registerEmployee(Employee emp)throws Exception;
}
