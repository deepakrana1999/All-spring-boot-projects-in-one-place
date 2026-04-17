package com.nt.config;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(basePackages="com.nt.sbeans")
public class Appcfg {

 public Appcfg() 
 {
	 System.out.println("Appcfg.Appcfg()::0-pram constructer");
 }
 @Bean(name="ltime")
 public LocalTime createLTime() 
 {
	 System.out.println("Appcfg.createLTime()");
	 return LocalTime.now();
 }

 
 @Bean(name="ldate")
 public LocalDate createLDate() 
 {
	 System.out.println("Appcfg.createLDate()");
	 return LocalDate.now();
 }
}

