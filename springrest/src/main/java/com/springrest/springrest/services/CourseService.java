package com.springrest.springrest.services;

import java.util.List;
import java.util.Optional;

import com.springrest.springrest.entities.Courses;

public interface CourseService {
	
//	Here are methods which are meant for provide data and information to the controllers as the need.
//	These methods are implemented in CourseServiceImpl class.
	public List<Courses> getCourses();

	public Courses getCourse(Long id);

	public Courses addCourse(Courses course);

	public Courses updateCourse(Courses templist);

	public void deleteCourse(Long id);
	
}
