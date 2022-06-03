package com.lt.src.repository;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.lt.constant.DataCollections;
import com.lt.src.bean.Course;

@Repository
public class CourseDaoImpl {

	public void saveCourse(Course course) {
		DataCollections.courses.add(course);
	}

	public List<Course> getAllCourse() {
		return DataCollections.courses;
	}

	public List<Course> getCourseByInstructor(String instructorName) {
		return DataCollections.courses.stream().filter(course->course.getInstructor().equalsIgnoreCase(instructorName))
											   .collect(Collectors.toList());
	}

	public List<String> getAllBranchesCourses() {
		return DataCollections.courseBranches;
		
	}
	public List<Course> getCourseByCourseName(List<String> courses) {
		return DataCollections.courses.stream().filter(course->courses.contains(course.getName())).collect(Collectors.toList());
	}

}
