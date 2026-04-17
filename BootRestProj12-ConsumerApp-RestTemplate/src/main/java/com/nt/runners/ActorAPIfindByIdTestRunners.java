package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nt.vo.ActorVO;
//@Component
public class ActorAPIfindByIdTestRunners implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	//@Order(2)
	//@ConditionalOnProperty(name="app.runner",havingValue = "runner2")
	public void run(String... args) throws Exception {
		//url
	  	String url="http://localhost:8081/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/find/{id}";
        //invoke/consume the api endpoint
		ResponseEntity<String>  response=template.getForEntity(url,String.class,41);
		System.out.println("response content ::"+response.getBody());
		System.out.println("response header value ::"+response.getStatusCode());
	    System.out.println("=============================================");
			//if we want only body will come not response statusCode
			//String response=template.getForObject(url, String.class);
			//System.out.println("response content::"+response);

			//Using JSON API to convert JSON content into List<Actor> Objects
			ObjectMapper mapper=new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			ActorVO actor=mapper.readValue(response.getBody(),ActorVO.class);
			System.out.println("VO object data"+actor);

			System.exit(0);
	}

}
