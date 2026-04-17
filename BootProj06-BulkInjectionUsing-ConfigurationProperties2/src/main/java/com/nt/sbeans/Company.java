package com.nt.sbeans;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Company {
	private String name;
	private String location;
	private Integer size;

}
