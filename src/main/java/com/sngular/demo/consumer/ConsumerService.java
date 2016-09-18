package com.sngular.demo.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public interface ConsumerService {

	User findRamdomUser();

}
