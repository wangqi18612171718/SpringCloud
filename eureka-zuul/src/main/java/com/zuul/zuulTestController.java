package com.zuul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class zuulTestController {

	@RequestMapping(value = "/receive",method = RequestMethod.GET)
	public String receive(){
		return "hello";
	}
	
}
