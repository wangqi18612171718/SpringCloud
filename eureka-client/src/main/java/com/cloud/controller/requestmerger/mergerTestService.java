package com.cloud.controller.requestmerger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.cloud.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * 测试请求合并，请求合并可以减少对服务器的连接次数
 * @author wangqi
 *
 */
@Service
public class mergerTestService {

	@HystrixCollapser(batchMethod = "getMergerUser", collapserProperties = {
			@HystrixProperty(name = "timerDelayInMilliseconds", value = "1000") })
	public Future<User> getMergerUser(Integer id) {
		System.out.println("获取用户");
		return null;
	}

	@HystrixCommand
	public List<User> getMergerUser(List<Integer> ids) {
		List<User> users = new ArrayList<User>();
		for (Integer id : ids) {
			System.out.println(id);
			User user = new User();
			user.setId(id);
			user.setName("ew" + id);
			users.add(user);
		}
		return users;
	}
}
