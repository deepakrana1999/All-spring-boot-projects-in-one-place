package com.nt.runners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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
	  	String json_body="{\"aid\":41,\r\n"
	  	        + "  \"aname\": \"rajesh\",\r\n"
	  			+ "  \"catagory\": \"hero\",\r\n"
	  			+ "  \"fee\": 790000.00,\r\n"
	  			+ "  \"industry\": \"Tollywood\",\r\n"
	  			+ "  \"dob\": \"1942-01-16T19:08:35.120\"\r\n"
	  			+ "}";
	  	//http request header
	  	HttpHeaders headers=new HttpHeaders();
	  	headers.setContentType(MediaType.APPLICATION_JSON);
	  	//prepare HttpEntity<String> object having body and headers
	  	HttpEntity<String> request=new HttpEntity<>(json_body,headers);
	  	//consume the service
	  	template.put(url, request,String.class);
	  	System.out.println("Actor updated");


	  	System.exit(0);
		
	}

}
