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
public class ActorAPIRegisterActorTestRunners implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	//@Order(3)
	//@ConditionalOnProperty(name="app.runner",havingValue = "runner3")
	public void run(String... args) throws Exception {
		//url
	  	String url="http://localhost:8081/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/register";
	  	//jsonBody
	  	String json_body="{\"aname\": \"Rajesh Kumar\",\r\n"
	  			+ "  \"catagory\": \"hero no1\",\r\n"
	  			+ "  \"fee\": 1550011.00,\r\n"
	  			+ "  \"industry\": \"Bollywood\",\r\n"
	  			+ "  \"dob\": \"1942-12-29T11:19:36.980\"\r\n"
	  			+ "}";
	  	//http request header
	  	HttpHeaders headers=new HttpHeaders();
	  	headers.setContentType(MediaType.APPLICATION_JSON);
	  	//prepare HttpEntity<String> object having body and headers
	  	HttpEntity<String> request=new HttpEntity<>(json_body,headers);
	  	//consume the service
	  	ResponseEntity<String> response=template.exchange(url,HttpMethod.POST, request,String.class);
	  	System.out.println("result::"+response.getBody());
	  	System.out.println("response status code::"+response.getStatusCode());

	  	System.exit(0);
	}

}
