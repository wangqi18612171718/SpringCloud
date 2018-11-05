package com.cloud.rabbitmq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface sendService {

	@Output("myInput")
	SubscribableChannel sendInfo();
}
