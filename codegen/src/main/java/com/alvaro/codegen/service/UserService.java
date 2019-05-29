package com.alvaro.codegen.service;


import com.example.generated.model.User;
import com.example.generated.model.UserResponse;

public interface UserService {
	
	User findById(Integer userId);
	
	void createUser(User user);
	
	void updateUser(Integer userId,User user);
	
	void deleteUser(Integer userId);
	
	UserResponse findAll();

}
