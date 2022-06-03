package com.lt.src.serviceInt;



import java.util.List;

import com.lt.src.bean.Course;

public interface CourseServiceInterface {

	void addCourse();

	void removeCourse();
	
	Course getCourse();
	
	List<Course> getCourses();
	
	List<Course> getCoursesByCourseName(List<String> courses);
}

