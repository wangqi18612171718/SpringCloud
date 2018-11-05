package com.cloud.controller.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author wangqi
 *
 */
@FeignClient(name = "provide",fallback = hystrixFallBack.class)
public interface feignTestClient {

	@RequestMapping(method = RequestMethod.GET,value = "/getHello/{name}")
	public String getHello(@PathVariable("name") String name);
	
	@RequestMapping(method = RequestMethod.GET,value = "/timeOutHello")
	public String timeOutHello();
	
}
