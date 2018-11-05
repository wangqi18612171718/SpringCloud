package com.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.cloud.controller.rabbitmq.receiveService;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
@ServletComponentScan
@EnableBinding(receiveService.class)
public class eurekaClientApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(eurekaClientApp.class).web(true).run(args);
	}
	
	@StreamListener("myInput")
	public void onReceive(byte[] args){
		System.out.println("接收到的消息："+new String(args));
	}
}
