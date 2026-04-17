package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
	    ResponseEntity<List<ActorVO>> response=template.exchange(url,
	    		                                                 HttpMethod.GET,
	    		                                                 null,
	    		                                                 new ParameterizedTypeReference<List<ActorVO>>() { });
	    List<ActorVO> listActor=response.getBody();
	    listActor.forEach(System.out::println);

	  	System.exit(0);
	}

}
