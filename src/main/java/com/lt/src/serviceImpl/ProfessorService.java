package com.lt.src.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.constant.InputConstants;
import com.lt.constant.Role;
import com.lt.src.bean.Course;
import com.lt.src.bean.Professor;
import com.lt.src.bean.Student;
import com.lt.src.bean.User;
import com.lt.src.repository.CourseDaoImpl;
import com.lt.src.repository.ProfessorDaoImpl;
import com.lt.src.repository.StudentDaoImpl;
import com.lt.src.repository.UserDaoImpl;
import com.lt.src.serviceInt.ProfessorServiceInterface;

@Service
public class ProfessorService implements ProfessorServiceInterface{

	@Autowired
	private ProfessorDaoImpl professorDao;
	@Autowired
	private UserDaoImpl userDao;
	@Autowired
	private CourseDaoImpl courseDao;
	@Autowired
	private StudentDaoImpl studentDao;
	@Autowired
	private UserService userService; 


	@Override
	public void addProfessor() {
		boolean isExit = false;
		while(!isExit) {
			User user = new User();
			System.out.println("Enter the emailId");
		   Professor professor = new Professor();
			professor.setName(InputConstants.sc.next());
			professorDao.saveProfessor(professor);
			user.setUserName(professor.getName());
			user.setPassword("Admin@123");
			userService.createUser(user, 1, Role.Professor);
			userDao.saveUser(user);
			System.out.println("Professor successfully added");
			System.out.println("Press 1 to exit or if you want to continue to add new course press 2");
			if(InputConstants.sc.nextInt()==1) {
				isExit = true;
			}
		}		
	}




	@Override
	public void viewEnrolledStudents(User userObj) {
		List<Course> courses = courseDao.getCourseByInstructor(userObj.getFirstName());
		List<Student> students =  studentDao.getStudentsByCourseName(courses.stream().map(Course::getName).collect(Collectors.toList()));
		List<User> studentUsers = userDao.getStudentById(students.stream().map(Student::getStudentId).collect(Collectors.toList()));

		System.out.printf("%10s %10s","StudentName","Subject");
		System.out.println();
		studentUsers.stream().forEach(studentUser->{
			students.stream().filter(std->std.getStudentId().equals(studentUser.getUserId()))
			.forEach(std->{
				System.out.format("%10s %10s",studentUser.getUserName(),std.getCourse());
				System.out.println();
			});
		});
		System.out.println("Press 1 for go back");
		InputConstants.sc.nextInt();
	}

	@Override
	public void viewCourse(User userObj) {
		List<Course> courses = courseDao.getCourseByInstructor(userObj.getFirstName());
		System.out.printf("Subject");
		courses.stream().forEach(course->System.out.format("\n"+course.getName()));
		System.out.println();
		System.out.println("Press 1 for go back");
		InputConstants.sc.nextInt();
		
	}

}
