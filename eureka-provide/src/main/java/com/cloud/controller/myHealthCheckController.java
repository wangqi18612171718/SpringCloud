package com.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;

/**
 * 健康检察并修改服务实例的状态
 * @author wangqi
 *
 */

@Component
public class myHealthCheckController implements HealthCheckHandler{

	@Autowired
	private myHealthIndicator healthIndicator;
	@Override
	public InstanceStatus getStatus(InstanceStatus currentStatus) {
		Status status = healthIndicator.health().getStatus();
		if(status.equals(Status.UP)){
			return InstanceStatus.UP;
		}else{
			return InstanceStatus.DOWN;
		}
	}

}
