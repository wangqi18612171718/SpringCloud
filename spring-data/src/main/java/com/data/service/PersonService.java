package com.data.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.model.Person;
import com.data.redis.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> getPersons(){
		Iterable<Person> persons = personRepository.findAll();
		List<Person> datas = new ArrayList<Person>();
		for(Iterator<Person> it = persons.iterator();it.hasNext();){
			Person p = it.next();
			datas.add(p);
		}
		return datas;
	}
	
	public void save(String name){
		Person p = new Person();
		p.setName(name);
		personRepository.save(p);
	}
}
