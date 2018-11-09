package com.cloud.controller.configServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class configServerController {

	@Autowired
	private Environment ven;
	
	/**
	 * 读取配置的信息应该配置在bootstrap.yml配置文件中
	 * @return
	 */
	@RequestMapping(value = "/getConfig",method = RequestMethod.GET)
	public String getConfig(){
		System.out.println("获取配置参数！！！");
		return ven.getProperty("test.user.name");
	}
}
