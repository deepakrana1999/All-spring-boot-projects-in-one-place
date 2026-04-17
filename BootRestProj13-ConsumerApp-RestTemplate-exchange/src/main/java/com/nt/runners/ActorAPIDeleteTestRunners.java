package com.nt.runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class ActorAPIDeleteTestRunners implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	//@Order(3)
	//@ConditionalOnProperty(name="app.runner",havingValue = "runner3")
	public void run(String... args) throws Exception {
		//url
	  	String url="http://localhost:8081/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/remove/{id}";
	  	//consume the service
	  	ResponseEntity<String> response=template.exchange(url,HttpMethod.DELETE,null,String.class,65);
	  	System.out.println("Actor deleted::"+response.getBody());


	  	System.exit(0);
	}

}
