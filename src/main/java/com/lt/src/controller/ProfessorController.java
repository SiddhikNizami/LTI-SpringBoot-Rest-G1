/**
 * 
 */
package com.lt.src.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.constant.Role;
import com.lt.src.bean.Professor;
import com.lt.src.bean.User;
import com.lt.src.repository.UserDaoImpl;
import com.lt.src.serviceImpl.UserService;
import com.lt.src.serviceInt.ProfessorServiceInterface;
import com.lt.src.serviceInt.UserServiceInterface;

/**
 * @author user217
 *
 */
@RestController
public class ProfessorController {
	@Autowired
	ProfessorServiceInterface professorService;
	@Autowired
	UserServiceInterface userService;
	@Autowired
	private UserService userServiceDao; 
	@Autowired
	private UserDaoImpl userDao;
	
	@RequestMapping(value="/addProfessor",method = RequestMethod.POST)
	public void addProfessor(@RequestBody Professor professor,@RequestBody User user) {
		professor.setName(professor.getName());
		user.setUserName(professor.getName());
		professorService.addProfessor(professor);
		user.setPassword("Admin@123");
		userServiceDao.createUser(user, 1, Role.Professor);
		userDao.saveUser(user);
		
		
		
	}

}
