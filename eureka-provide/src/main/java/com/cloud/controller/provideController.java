package com.cloud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.model.User;

@RestController
public class provideController {

	@RequestMapping(value = "/getUser/{id}",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable Integer id,HttpServletRequest request){
		User user = new User();
		user.setId(id);
		user.setName("王奇");
		user.setMessage(request.getRequestURL().toString());
		return user;
	}
	
	//模拟服务提供者出现异常
	public static boolean canVisitDb = true;
	//模拟异常，改变服务实例的状态（up正常状态 down异常状态）
	@RequestMapping(value = "/getDb/{can}",method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public String getDb(@PathVariable boolean can){
		canVisitDb = can;
		return "status is："+canVisitDb;
	}
}
