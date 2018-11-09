package com.data.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.data.model.Student;

public class studentDaoImpl implements studentDaoCustom {

	@Autowired
	private RedisTemplate redisTemplate;
	
	public List<Student> myQuery() {
		redisTemplate.execute(new RedisCallback<Object>() {

            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(redisTemplate.getStringSerializer().serialize("name"),
                               redisTemplate.getStringSerializer().serialize("wangshuai"));
                return null;
            }
        });
		return null;
	}

}
