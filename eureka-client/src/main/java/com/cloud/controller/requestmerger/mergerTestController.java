package com.cloud.controller.requestmerger;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.model.User;

@RestController
public class mergerTestController {

	@Autowired
	private mergerTestService testService; 
	
	@RequestMapping(value = "/getMergerUser",method = RequestMethod.GET)
	public String getMergerUser() throws Exception{
		Future<User> u1 = testService.getMergerUser(1);
		Future<User> u2 = testService.getMergerUser(1);
		Future<User> u3 = testService.getMergerUser(1);
		User p1 = u1.get();
		User p2 = u2.get();
		User p3 = u3.get();

		return "c测试而已";
	}
}
