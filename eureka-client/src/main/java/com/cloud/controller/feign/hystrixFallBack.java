package com.cloud.controller.feign;

import org.springframework.stereotype.Component;

@Component
public class hystrixFallBack implements feignTestClient {

	@Override
	public String getHello(String name) {
		System.out.println("访问出错！！！！");
		return "错误了,你没访问到";
	}

	@Override
	public String timeOutHello() {
		System.out.println("超时后打开断路器");
		return "超时后打开断路器";
	}

}
