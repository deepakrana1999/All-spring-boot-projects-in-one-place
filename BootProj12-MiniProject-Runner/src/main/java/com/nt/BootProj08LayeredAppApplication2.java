package com.nt;


import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ConfigurableApplicationContext;
import com.nt.controller.PayrollMgmtOperationController;
import com.nt.model.Employee;

@SpringBootApplication

public class BootProj08LayeredAppApplication2 {

	public static void main(String[] args) {
		//get access to IOC Container
		 SpringApplication.run(BootProj08LayeredAppApplication2.class, args);
		

	}

}
