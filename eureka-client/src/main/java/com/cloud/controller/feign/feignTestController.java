package com.cloud.controller.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;

@RestController
public class feignTestController {

	@Autowired
	private feignTestClient testClient;

	@RequestMapping(value = "/sale/getHello", method = RequestMethod.GET)
	public String getHello() {
		String json = testClient.getHello("王法");
		return json;
	}

	@RequestMapping(value = "/timeOutHello", method = RequestMethod.GET)
	public String timeOutHello() {
		String json = testClient.timeOutHello();
		HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory
				.getInstance(HystrixCommandKey.Factory.asKey("feignTestClient#timeOutHello()"));
		System.out.println("断路器状态："+ breaker.isOpen());
		return json;
	}
}
