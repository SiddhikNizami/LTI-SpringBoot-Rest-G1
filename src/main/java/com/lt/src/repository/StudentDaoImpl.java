package com.lt.src.repository;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.lt.constant.DataCollections;
import com.lt.src.bean.RegisterCourse;
import com.lt.src.bean.Student;

/**
 * @author user217
 *student Service contatined the student information here
 */
@Repository
public class StudentDaoImpl  {

	
//	StudentService studentService = new StudentService();
	
	public List<Student> getStudentsByCourseName(List<String> courses) {
		
		return DataCollections.students.stream()
				.filter(student-> (student.getCourse()!=null && courses.stream().filter(course->student.getCourse().contains(course)).findAny().isPresent()))
				.collect(Collectors.toList());
	}
	public void courseRegistration(RegisterCourse registerCourse) {
		
		DataCollections.registerCourse.add(registerCourse);
	}
	public void dropCourse() {
//		studentService.dropCourse();
	}

	public List<String> addCourse(List<String> courses) {
//		return DataCollections.courseBranches.stream()
//				.filter(student-> courses.stream().filter(course->student..contains(course)).findAny().isPresent())
//				.collect(Collectors.toList());
		return null;
		
	}

	public void viewGrade() {
		// TODO Auto-generated method stub
		
	}

	public Student getStudentByID(UUID userId) {
		// TODO Auto-generated method stub
		return DataCollections.students.stream().filter(student-> student.getStudentId().equals(userId))
				.findAny().orElse(null);
				
		
	}
	public void updateStudent(Student student, UUID userId) {
		DataCollections.students.stream().filter(std-> std.getStudentId().equals(userId))
		.map(std->std=student).collect(Collectors.toList());
	}

	public void save(Student student) {
		DataCollections.students.add(student);
	}
}
