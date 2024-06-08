package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;import org.springframework.web.client.HttpClientErrorException.NotAcceptable;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Courses;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao; // this object will manipulate insert delete data from database.
	
	@Override
	public List<Courses> getCourses() {
		
		return courseDao.findAll();//Fetch all course
	}

	@Override
	public Courses getCourse(Long id) {
		return courseDao.findById(id).get();//fetch a single by findById() and get() convert this to Courses type
	}



	@Override
	public Courses addCourse(Courses course) {
	if(course.getId()!=' '||course.getId()!=0) {
		courseDao.save(course);// to save this course to DB
	}
		return course;
	}

	@Override
	public Courses updateCourse(Courses templist) {
	
		if(templist.getId()!=' '||templist.getId()!=0) {
			courseDao.save(templist);// to save this course to DB
		}
		//these is no method for update so simply if we want update we just save(),
//		save(), first check if data with id is exist or not if exist then replace esle create new.
		return templist;
	}


	@Override
	public void deleteCourse(Long id) {
	Courses entity=courseDao.findById(id).get(); //first find the entity of the given id (entity means row of that id) then delete.
	courseDao.delete(entity);//delete that entity from DB

	}
}
	
	//without using Database :code start here
//	List<Courses> list;
//	
//	public CourseServiceImpl() {
//		list=new ArrayList<>();
//		list.add(new Courses(100,"Java Batch","Java Fullstack"));
//		list.add(new Courses(101,"Html","For Fullstack Web development"));
//	}
//
//	@Override
//	public List<Courses> getCourses() {
//		return list;
//	}
//
//	@Override
//	public Courses getCourse(long courseId) {
//		Courses course=null;
//			for(Courses c:list) {
//			if(c.getId()==courseId) {
//				course=c;
//			}
//		}
//		return course;
//	}
//
//	@Override
//	public Courses addCourse(Courses course) {
//		list.add(course);
//		return course;
//	}
//
//	@Override
//	public Courses updateCourse(Courses templist) {
////		Courses courses=null;
//		for(Courses c:list) {
//			if(c.getId()==templist.getId()) {
//				c.setTitle(templist.getTitle());
//				c.setDiscription(templist.getDiscription());
//				return c;
//			}
//			
//		}
//		return null;
//	}
//
//	@Override
//	public void deleteCourse(long id) {
//		// TODO Auto-generated method stub
//		list.removeIf(course -> course.getId() == id);
//		
//	}
	
	//without using Database code end here.


