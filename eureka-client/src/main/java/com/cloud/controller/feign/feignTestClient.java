package com.cloud.controller.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * feignClient 中的url是指的集群网关地址
 * @author wangqi
 *
 */
@FeignClient(name = "user",fallback = hystrixFallBack.class,url="http://localhost:9000/getHello/")
public interface feignTestClient {

	@RequestMapping(method = RequestMethod.GET,value = "/getHello/{name}")
	public String getHello(@PathVariable("name") String name);
	
	@RequestMapping(method = RequestMethod.GET,value = "/timeOutHello")
	public String timeOutHello();
	
}
