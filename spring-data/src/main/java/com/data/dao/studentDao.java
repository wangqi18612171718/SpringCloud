package com.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.data.model.Student;

public interface studentDao extends JpaRepository<Student, Integer>,studentDaoCustom {

	/**
	 * 根据名称查询
	 * @param name
	 * @return
	 */
	List<Student> findByName(String name);
	
	/**
	 * 使用query注解方式查询
	 * @param name
	 * @return
	 */
	@Query("select s from Student s where s.name = ?1")
	List<Student> findStudentName(String name);
	
	/**
	 * 使用原生的sql语句查询
	 * @param name
	 * @return
	 */
	@Query(value = "select * from student where name = ?1",nativeQuery = true)
	List<Student> findNativeName(String name);
}
