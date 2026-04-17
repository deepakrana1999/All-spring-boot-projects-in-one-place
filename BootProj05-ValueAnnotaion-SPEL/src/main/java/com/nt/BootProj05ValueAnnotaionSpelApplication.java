package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.DiagnosticCenter;

@SpringBootApplication
public class BootProj05ValueAnnotaionSpelApplication {

	public static void main(String[] args) {
		//get Access to IOC Container
		try(
		ConfigurableApplicationContext ctx = SpringApplication.run(BootProj05ValueAnnotaionSpelApplication.class, args))
		{
			DiagnosticCenter dc= ctx.getBean("dc",DiagnosticCenter.class);
			System.out.println(dc);
		}
	}

}
