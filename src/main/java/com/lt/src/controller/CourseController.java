/**
 * 
 */
package com.lt.src.controller;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.src.bean.Course;
import com.lt.src.repository.CourseDaoImpl;
import com.lt.src.serviceImpl.CourseService;
import com.lt.src.serviceInt.CourseServiceInterface;

import ch.qos.logback.core.subst.Token.Type;

/**
 * @author user217
 *
 */
@RestController
public class CourseController {

	@Autowired
	CourseServiceInterface couseService;
	
	@Autowired
	CourseDaoImpl dao;
//	
//	@RequestMapping(value="/addCourse",method = RequestMethod.POST)
//	public ResponseEntity getCourse(@RequestBody Course course)
//	{
//	        dao.saveCourse(course);
//	return new ResponseEntity(course, HttpStatus.OK);
//	}
	
	@RequestMapping(value="/addCourse2",method = RequestMethod.POST)
	public ResponseEntity SaveCourseDetails (@RequestBody Course course) {
		
	       couseService.addCourse();
		return new ResponseEntity(course, HttpStatus.OK);
		
	}
}
