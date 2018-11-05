package com.cloud.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sendController {

	@Autowired
	private sendService service;
	
	@RequestMapping(value = "/send",method = RequestMethod.GET)
	public String send(){
		Message msg = MessageBuilder.withPayload("Hello word !!!".getBytes()).build();
		service.sendInfo().send(msg);
		return "success";
	}
}
