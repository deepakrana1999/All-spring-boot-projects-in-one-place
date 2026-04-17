package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
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
		ResponseEntity<ActorVO> response=template.exchange(url,
				                                           HttpMethod.GET,
				                                           null,//no body in GET ,so null is passed
				                                           ActorVO.class,
				                                           61);
		//display the out put
		ActorVO vo=response.getBody();
		System.out.println("result is ::"+vo);
		System.out.println("response status code::"+response.getStatusCode());
	}

}
