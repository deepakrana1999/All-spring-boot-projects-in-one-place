package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@ConfigurationProperties(prefix="per.info")
@Component("pDetails")
@Data
public class PersonDetails {
     //@Value("${my.info.name}")
	private String name;
	private String addrs;
	private Long mobileno;
	private Integer age;
	private Double salary;
	
	private String[] nickNames;
	private List<String> friends;
	private Set<Long> phones;
	private Map<String,Object>idDetails;
	@Autowired
	private Company comp;
	
    
	
}
