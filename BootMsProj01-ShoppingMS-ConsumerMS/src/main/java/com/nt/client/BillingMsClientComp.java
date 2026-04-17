package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BillingMsClientComp {

	@Autowired
	private DiscoveryClient client;
	
	public ResponseEntity<String> invockDoBilling()
	{
		//get target MS service Instance from the Eureka Server
		List<ServiceInstance> listSI=client.getInstances("BillingMs");
		
		//get endpoint details
		URI url=listSI.get(0).getUri();  //giving http://localhost:6061
		//complete the url
		String urlInfo=url+"/billing-api/bill";
		//Create RestTemplate class object
		RestTemplate template=new RestTemplate();
		//invock the Target class Endpoint
		ResponseEntity<String> resp=template.exchange(urlInfo,HttpMethod.GET, null,String.class);
		return resp;
	}
}
