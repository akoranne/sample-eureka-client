package com.sngular.demo.consumer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
@Service
public class ConsumerServiceImpl implements ConsumerService {

	private RestTemplate restTemplate;
	
	public ConsumerServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackUser", commandProperties=@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value="20000"))
	public User findRamdomUser() {
		
		return restTemplate.getForObject("http://users-service/api/v1/users/random", User.class);
	}
	
	public User getFallbackUser() {
		return new User().setId("test").setEmail("test@test.com").setUserName("test");
	}
}
