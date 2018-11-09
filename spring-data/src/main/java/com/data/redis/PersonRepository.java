package com.data.redis;

import org.springframework.data.repository.CrudRepository;

import com.data.model.Person;

public interface PersonRepository extends CrudRepository<Person, String>{

}
