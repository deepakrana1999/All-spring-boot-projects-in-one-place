package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nt.vo.ActorVO;

//@Component
public class ActorAPIfindAllTestRunners implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	//@Order(1)

	//@ConditionalOnProperty(name="app.runner",havingValue = "runner1")
	public void run(String... args) throws Exception {
		//url
	  	String url="http://localhost:8081/BootRestProj11-MiniProject-ActorAPI-Swagger/actor-api/all";
        //invoke/consume the api endpoint
		/*ResponseEntity<String>  response=template.getForEntity(url,String.class);
		System.out.println("response content ::"+response.getBody());
		System.out.println("response header value ::"+response.getStatusCode());*/

	  	//if we want only body will come not response statusCode
	  	String response=template.getForObject(url, String.class);
	  	//System.out.println("response content::"+response);

	  	//Using JSON API to convert JSON content into List<Actor> Objects
	  	ObjectMapper mapper=new ObjectMapper();
	  	mapper.registerModule(new JavaTimeModule());
	  	List<ActorVO> list=mapper.readValue(response, new TypeReference<List<ActorVO>>(){ });
	  	list.forEach(vo->{
	  		System.out.println(vo);
	  	});

	  	System.exit(0);
	}

}
