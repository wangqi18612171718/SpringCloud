package com.data.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("Person")
public class Person {
	
	@Id
	private Integer id;
	
	@Indexed
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
