package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Courses;

public interface CourseDao extends JpaRepository<Courses, Long>{
	//Here we extends JpaRepository<Course,Long> Course is our table in DB and the unique id is type Long
	//it will create table themselves and all the queries everything done himself we just need to create and object of this class
	// and as we created in CourseServiceImpl class

}
