package com.springrest.springrest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

//for controller 
@RestController
public class MyController {
	@Autowired
	private CourseService courseService; //The object of this class, send the data which we ask to him
	//Mapping Demo for my project.
	@GetMapping("/home")
	public String home() {
		return "This is Home Page, As well as my first page. and this is example";
	}
	
//	Mapping for request from URL: localhost:<port>/courses with GET method: ask for all courses.
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/courses")
	public List<Courses> getCourses(){
		return courseService.getCourses();
	}
	
//	Mapping for request from URL: localhost:<port>/courses/<CoursId> with GET method: ask for a course with CourseId
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@PathVariable Long courseId) {
		return courseService.getCourse(courseId);
	}
	
//	Mapping for request from URL: localhost:<port>/courses with POST method with a json file of the course details : ask to add a course in database.
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) {
		return courseService.addCourse(course);
		
	}
		
//	Mapping for request from URL: localhost:<port>/courses with PUT method with a json file of the course details to update
//	and it ask to update a courses.
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses templist) {
		return courseService.updateCourse(templist);
		
	}
	
//	Mapping for request from URL: localhost:<port>/courses/<CourseId> with DELETE method : ask for delete a course.
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/courses/{id}")
	public String deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(Long.parseLong(id));
		return "Course with ID : "+id+", is deleted successfully";
		
	}
}
