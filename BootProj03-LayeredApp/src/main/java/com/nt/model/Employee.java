package com.nt.model;

import lombok.Data;

@Data
public class Employee {
   private Integer empNo;
   private String eName;
   private String job;
   private Integer mgr;
   private String hireDate;
   private Double sal;
   private Double comm;
   private Integer deptNo;
   private Double grossSalary;
   private Double netSalary;
}
