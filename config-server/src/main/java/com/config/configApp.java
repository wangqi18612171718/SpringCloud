package com.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class configApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(configApp.class).run(args);
	}
}
