package com.dashboard;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class dashboardApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(dashboardApp.class).properties("server.port=8083").run(args);
	}
}
