package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@FeignClient("BillingMs")  //target MS service id
//here this annotation calls LoadbalancerClient choose method to get the service instance of target MS
public interface IBillingMsClientComp {
	
@GetMapping("/billing-api/bill")
//here internaly RestTemplate objct exchange will call taking the given url
public ResponseEntity<String> invockDoBilling();

}
