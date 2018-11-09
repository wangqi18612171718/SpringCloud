package com.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.data.model.Person;
import com.data.model.Student;
import com.data.service.PersonService;
import com.data.service.studentService;

@RestController
public class studentController {

	@Autowired
	private studentService service;
	
	@Autowired
	private PersonService personService;
	
	
	@RequestMapping(value = "/getPersons",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getPersons(){
		return personService.getPersons();
	}
	
	@RequestMapping(value = "/save/{name}",method = RequestMethod.GET)
	public String save(@PathVariable String name){
		 personService.save(name);
		 return "success";
	}
	
	@RequestMapping(value = "/getStudents",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudents(){
		
		return service.getStudents();
	}
	
	@RequestMapping(value = "/findByName/{name}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> findByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@RequestMapping(value = "/saveStudent",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Student saveStudent(){
		service.saveStudent();
		return null;
	}
}
