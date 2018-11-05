package com.cloud.controller.cache;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;

@Service
public class cacheTestService {

	/**
	 * 使用缓存，多次相同参数调用改方法会再缓存中调用
	 * @param id
	 * @return
	 */
	@CacheResult
	@HystrixCommand
	public String getCache(Integer id){
		System.out.println("调用 getCache 方法");
		return "";
	}
	
	/**
	 * 创建缓存并指定commandkey
	 * @param id
	 * @return
	 */
	@CacheResult
	@HystrixCommand(commandKey = "testCache")
	public String createCache(Integer id){
		System.out.println("创建缓存");
		return "";
	}
	
	/**
	 * 清除指定commandkey缓存
	 * @param id
	 * @return
	 */
	@CacheRemove(commandKey = "testCache")
	@HystrixCommand
	public String removeCache(Integer id){
		System.out.println("清除缓存");
		return "";
	}
}
