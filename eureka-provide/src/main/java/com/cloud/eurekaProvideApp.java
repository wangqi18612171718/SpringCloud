package com.cloud;


import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.cloud.rabbitmq.sendService;


@SpringBootApplication
@EnableEurekaClient
@EnableBinding(sendService.class)
public class eurekaProvideApp {

	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		String port = scan.nextLine();
		new SpringApplicationBuilder(eurekaProvideApp.class).properties("server.port="+port).run(args);
	}
}
