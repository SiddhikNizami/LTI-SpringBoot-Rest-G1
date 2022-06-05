package com.lt.src.serviceInt;

import com.lt.src.bean.Professor;
import com.lt.src.bean.User;

public interface ProfessorServiceInterface {

	void addProfessor(Professor professor);

	void viewEnrolledStudents(User userObj);

	void viewCourse(User userObj);

}
