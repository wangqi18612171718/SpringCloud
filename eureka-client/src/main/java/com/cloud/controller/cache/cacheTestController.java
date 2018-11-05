package com.cloud.controller.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cacheTestController {

	@Autowired
	private cacheTestService testService;
	
	@RequestMapping(value = "/getCache",method = RequestMethod.GET)
	public String getCache(){
		for(int i=0;i<3;i++){
			testService.getCache(1);
		}
		return "";
	}
	
	@RequestMapping(value = "/testCache",method = RequestMethod.GET)
	public String testCache(){
		testService.createCache(1);
		testService.createCache(1);
		testService.createCache(1);
		System.out.println("准备清除缓存");
		testService.removeCache(1);
		testService.createCache(1);

		return "";
	}
}
