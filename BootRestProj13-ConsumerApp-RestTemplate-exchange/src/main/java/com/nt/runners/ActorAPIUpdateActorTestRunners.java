package com.nt.runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
//@Component
public class ActorAPIUpdateActorTestRunners implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	//@Order(3)
	//@ConditionalOnProperty(name="app.runner",havingValue = "runner3")
	public void run(String... args) throws Exception {
		//url
	  	String url="http://localhost:8081/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/update";
	  	//jsonBody
	  	String json_body="{\"aid\":82,\r\n"
	  	        + "  \"aname\": \"Rajesh Kumar\",\r\n"
	  			+ "  \"catagory\": \"hero no1\",\r\n"
	  			+ "  \"fee\": 1790099.10,\r\n"
	  			+ "  \"industry\": \"Tollywood\",\r\n"
	  			+ "  \"dob\": \"1982-09-05T17:54:49.330\"\r\n"
	  			+ "}";
	  	//http request header
	  	HttpHeaders headers=new HttpHeaders();
	  	headers.setContentType(MediaType.APPLICATION_JSON);
	  	//prepare HttpEntity<String> object having body and headers
	  	HttpEntity<String> request=new HttpEntity<>(json_body,headers);
	  	//consume the service
	  	ResponseEntity<String> response=template.exchange(url,HttpMethod.PUT, request,String.class);
	  	System.out.println("ersult is::"+response.getBody());


	  	System.exit(0);
		
	}

}
