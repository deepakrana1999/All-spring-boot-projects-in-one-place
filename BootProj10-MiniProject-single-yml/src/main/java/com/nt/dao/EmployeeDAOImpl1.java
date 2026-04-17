package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;


@Repository("empDao-mysql")
@Profile({"dev","test"})
public class EmployeeDAOImpl1 implements IEmployeeDAO {
	  @Autowired
     private DataSource ds;
    private static final String SET_EMPS_QUERY="SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM Employee WHERE JOB IN(?,?,?)ORDER BY JOB";
    private static final String INSERT_EMP_QUERY="INSERT INTO Employee(ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO)VALUES(?,?,?,?,?,?,?)";
    List<Employee> list=null;
    
	public EmployeeDAOImpl1() {
	   System.out.println("EmployeeDAOImpl1::0-param constructer");
	}
    @Override
	public List<Employee> showEmployeeByJobs(String job1, String job2, String job3) throws Exception {
		System.out.println("EmployeeMangementImpl::DataSource obj::"+ds.getClass());
    	System.out.println("EmployeeDAOImpl1.showEmployeeByJobs()");
    	
    	
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(SET_EMPS_QUERY))
		{
			ps.setString(1, job1);
			ps.setString(2, job2);
			ps.setString(3, job3);
			
			list=new ArrayList<Employee>();
			try(ResultSet rs=ps.executeQuery())
			{
				while(rs.next()) 
				{
					Employee emp=new Employee();
					
					emp.setEmpNo(rs.getInt(1));
					emp.setEName(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setMgr(rs.getInt(4));
					emp.setHireDate(rs.getString(5));
					emp.setSal(rs.getDouble(6));
					emp.setComm(rs.getDouble(7));
					emp.setDeptNo(rs.getInt(8));
					
					list.add(emp);
				}
			}
		}
		catch(SQLException se) 
		{
			throw se;
		}
		catch(Exception e) 
		{
			throw e;
		}
		return list;
	}



	@Override
	public int registerEmployee(Employee emp) throws Exception {
		System.out.println("EmployeeMangementImpl::DataSource obj::"+ds.getClass());
		System.out.println("EmployeeDAOImpl1.registerEmployee()");
		
		try(Connection con=ds.getConnection();PreparedStatement ps=con.prepareStatement(INSERT_EMP_QUERY))
		{
			ps.setString(1,emp.getEName());
			ps.setString(2,emp.getJob());
			ps.setInt(3,emp.getMgr());
			ps.setString(4,emp.getHireDate());
			ps.setDouble(5,emp.getSal());
			ps.setDouble(6,emp.getComm());
			ps.setInt(7,emp.getDeptNo());
			
		    int count=ps.executeUpdate();
		    return count;
		}
		catch(SQLException se) 
		{
			throw se;
		}
		catch (Exception e) 
		{
			throw e;
		}
		
	}

}
