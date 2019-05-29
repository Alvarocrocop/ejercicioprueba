package com.alvaro.codegen.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.alvaro.codegen.service.UserService;
import com.alvaro.codegen.service.UserServiceImpl;
import com.example.generated.api.UsersApi;
import com.example.generated.model.User;
import com.example.generated.model.UserResponse;


@Controller
public class UserController implements UsersApi{

	@Autowired
	UserService userService;
	
	
	@Override
	public ResponseEntity<Void> createUser(@Valid User body) {
		userService.createUser(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deleteUser(Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<User> findUserById(Integer userId) {
		User userById = userService.findById(userId);
		return new ResponseEntity<User>(userById, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserResponse> getAllUsers() {
		UserResponse users = userService.findAll();
		return new ResponseEntity<UserResponse>(users,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> updateUser(Integer userId, @Valid User body) {
			
		userService.updateUser(userId, body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
