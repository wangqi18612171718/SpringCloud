package com.cloud.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * 健康管理器，处理服务实例是否健康
 * @author wangqi
 *
 */
@Component
public class myHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		if(provideController.canVisitDb){
			return new Health.Builder(Status.UP).build();
		}else{
			return new Health.Builder(Status.DOWN).build();
		}
	}

}
