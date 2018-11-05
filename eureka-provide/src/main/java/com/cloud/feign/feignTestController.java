package com.cloud.feign;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class feignTestController {

	@RequestMapping(value = "/getHello/{name}",method = RequestMethod.GET)
	public String getHello(@PathVariable("name") String name,HttpServletRequest request){
		
		return "hello word"+name + request.getRequestURL();
	}
	
	@RequestMapping(value = "/timeOutHello",method = RequestMethod.GET)
	public String getHello() throws Exception{
		System.out.println("测试超时了");
		Thread.sleep(1000);
		return "time out hello word";
	}
}
