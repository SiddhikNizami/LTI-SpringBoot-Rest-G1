/**
 * 
 */
package com.lt.src.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.src.bean.User;
import com.lt.src.repository.UserDaoImpl;
import com.lt.src.serviceInt.UserServiceInterface;

/**
 * @author user217
 *
 */
@RestController
public class UserController {

	@Autowired
	UserServiceInterface userservice;
	
	@Autowired
	UserDaoImpl userdao;
	
	@RequestMapping(value ="/post/saveUser", method = RequestMethod.POST)
	public ResponseEntity saveUser (@RequestBody User user) {
		
		userdao.saveUser(user);
		return new ResponseEntity(user,HttpStatus.OK);
	}
	 
	@RequestMapping(value ="/getAllUser",method = RequestMethod.GET)
	   public List<User> getAllUser(){
		return userdao.getAllUser();
	}

	@RequestMapping(value ="/getAllStudentUser",method = RequestMethod.GET)
	   public List<User> getAllStudentUser(){
		return userdao.getAllStudentUser();
	}
	
	@RequestMapping(value ="/getStudentById",method = RequestMethod.GET)
	   public List<User> getStudentById(@PathVariable List<UUID> studentIds){
		return userdao.getStudentById(studentIds);
	}
	
	@RequestMapping(value ="/registerUser", method = RequestMethod.POST)
	   public ResponseEntity createUser(@RequestBody User user) {
		userdao.saveUser(user);
		return new ResponseEntity(user,HttpStatus.OK); 
	}
	
}
