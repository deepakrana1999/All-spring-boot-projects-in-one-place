package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("dc")
@Data
public class DiagnosticCenter {
   
	@Value("3456")//hard coding
	private Integer id;
	//inject the values collected from the proterties file
	@Value("${dc.name}")
	private String name;
	@Value("${dc.addrs}")
	private String addrs;
	//injecting the system property values
	@Value("${user.name}")
	private String userName;
	@Value("${os.name}")
	private String osName;
	//injecting evn... variable values
	@Value("${Path}")
	private String pathDate;
	
	//SPEL based arithmetic and logical operations
	@Value("#{ds.diabeticTestPrice + ds.bpPrice}")
	private Float diabeticPackagePrice;
	@Value("#{ds.diabeticTestPrice + ds.bpPrice + ds.xrayPrice + ds.mriPrice + ds.ctscanPrice + ds.twoDechoPrice}")
	private Float fullBodyPackagePrice;
	@Value ("#{ds.bpPrice + ds.twoDechoPrice}")
	private Float heartPackagePrice;
	@Value("#{ds.ctscanPrice>1000}")
	private Boolean isCtscanCostly;
	
	@Autowired  //spring bean injection
	private DiagnosticServices service;
	
}
