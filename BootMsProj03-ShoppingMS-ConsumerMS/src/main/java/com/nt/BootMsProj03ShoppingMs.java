package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
//we have to add one extra stater which is OpenFeign
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BootMsProj03ShoppingMs {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj03ShoppingMs.class, args);
	}

}
