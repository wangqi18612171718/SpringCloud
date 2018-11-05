package com.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cloud.controller.feign.feignTestClient;
import com.cloud.model.Result;
import com.cloud.model.User;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

import feign.Feign;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

@Controller
@Configuration
public class clientController {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	@GetMapping("/getInfo")
	@ResponseBody
	public String getInfo(){
		RestTemplate rest = getRestTemplate();
		String json = rest.getForObject("http://provide/getUser/1", String.class);
		return json;
	}
	
	@Autowired
	public DiscoveryClient discoveryClient;
	
	//客户端抓取服务注册中心的服务列表
	@GetMapping("/getServiceCount")
	@ResponseBody
	public void getServiceCount(){
		List<String> serviceIds = discoveryClient.getServices();
		for(String serviceId:serviceIds){
			List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
			System.out.println(serviceId + ": " + instances.size());
		}
	}
	
	//获取注册中心服务列表中指定服务上的某个参数
	@GetMapping("/getMetadata")
	@ResponseBody
	public void getMetadata(){
		List<ServiceInstance> instances = discoveryClient.getInstances("provide");
		for(ServiceInstance instance:instances){
			String name = instance.getMetadata().get("company-name");
			System.out.println(instance.getPort() + ": " + name);
		}
	}
	
	@Autowired
	private LoadBalancerClient client;
	
	/**
	 * 根据LoadBalancerClient获取服务的某个实例信息
	 * @return
	 */
	@GetMapping("/getclient")
	@ResponseBody
	public ServiceInstance getclient(){
		ServiceInstance s = client.choose("provide");
		return s;
	}
	
	@Autowired
	private SpringClientFactory factory;
	
	/**
	 * 根据factory获取某个服务的负载均衡规则
	 * @return
	 */
	@GetMapping("/getFactory")
	@ResponseBody
	public String getFactory(){
		ZoneAwareLoadBalancer  lb = (ZoneAwareLoadBalancer)factory.getLoadBalancer("default");
		System.out.println(lb.getRule().getClass().getName());
		
		ZoneAwareLoadBalancer  lb2 = (ZoneAwareLoadBalancer)factory.getLoadBalancer("provide");
		System.out.println(lb.getRule().getClass().getName());
		
		return "";
	}
}
