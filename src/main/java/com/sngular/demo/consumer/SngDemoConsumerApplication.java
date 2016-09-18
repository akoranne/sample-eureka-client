package com.sngular.demo.consumer;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@RestController
public class SngDemoConsumerApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SngDemoConsumerApplication.class, args);
	}
	
	@Autowired
	private ConsumerService consumerService;
	
	@RequestMapping(value="test", method=GET)
	public User findRamdomUser() {
		
		return consumerService.findRamdomUser();
	}
}
