package com.zuul.config;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义路由规则
 * @author wangqi
 *
 */
//@Configuration
public class MyConfig {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@Bean
	public PatternServiceRouteMapper patternServiceRouteMapper() throws Exception{
		return new PatternServiceRouteMapper("(spring)-(zuul)-(?<module>.+)", "${module}/**");
	}
}
