package com.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.dao.studentDao;
import com.data.model.Student;

@Service
public class studentService {
	
	@Autowired
	private studentDao dao;

	public List<Student> getStudents(){
		dao.myQuery();
		return dao.findAll();
	}
	
	public List<Student> findByName(String name){
		return dao.findByName(name);
	}
	
	public Student saveStudent(){
		Student s = new Student();
		s.setName("fss");
		return dao.save(s);
	}
}
