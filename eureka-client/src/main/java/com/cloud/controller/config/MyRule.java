package com.cloud.controller.config;

import java.util.List;
import java.util.Random;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

/**
 * 自定义负载均衡规则
 * @author wangqi
 *
 */
public class MyRule implements IRule {

	private ILoadBalancer loadBalancer;
	
	@Override
	public Server choose(Object arg0) {
		System.out.println("这是自定义的负载均衡规则！！！");
		Random ran = new Random();
		int ranNum = ran.nextInt(10);
		List<Server> servers = loadBalancer.getAllServers();
		if(ranNum>7){
			Server s = getServersByPort(servers, 8080);
			return s ;
		}
		return getServersByPort(servers, 8081);
	}

	public Server getServersByPort(List<Server> servers,int port){
		for(Server server:servers){
			if(server.getPort() == port){
				return server;
			}
		}
		return null;
	}
	@Override
	public ILoadBalancer getLoadBalancer() {
		return this.loadBalancer;
	}

	@Override
	public void setLoadBalancer(ILoadBalancer loadBalancer) {
		this.loadBalancer = loadBalancer;
	}

}
