package com.lt.src.controller;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.src.bean.Student;
import com.lt.src.serviceImpl.StudentService;
import com.lt.src.serviceInt.StuentServiceInterface;

/**
 * @author user217
 *
 */
@RestController
public class StudentController {

	@Autowired
    StudentService studentService;
	

	@RequestMapping(value="/studentList",method = RequestMethod.POST)
	public ResponseEntity getListOfStudent(@RequestBody Student student ,@PathVariable UUID userID){
		
		student.setStudentId(student.getStudentId());
		studentService.addCourse(userID);
		return new ResponseEntity(student, HttpStatus.OK);
	}
}
