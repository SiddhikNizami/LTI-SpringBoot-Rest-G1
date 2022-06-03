package com.lt.src.serviceInt;

import com.lt.src.bean.User;

public interface ProfessorServiceInterface {

	void addProfessor();

	void viewEnrolledStudents(User userObj);

	void viewCourse(User userObj);

}
