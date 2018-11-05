package com.cloud.controller.rabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface receiveService {

	@Input("myInput")
	SubscribableChannel receive();
}
