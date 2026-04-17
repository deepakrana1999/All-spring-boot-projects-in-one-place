package com.nt.runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//@Component
public class ActorAPIPatchUpdateTestRunners implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	//@Order(3)
	//@ConditionalOnProperty(name="app.runner",havingValue = "runner3")
	public void run(String... args) throws Exception {
		//url
	  	String url="http://localhost:8081/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/update/{id}/{hikePercentage}";
	  	//set request factory (required for PATCH)
	  	template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	  	//consume the service
	  	String response=template.patchForObject(url,null,String.class,41,20.0);
	  	System.out.println("result::"+response);


	  	System.exit(0);
	}

}
