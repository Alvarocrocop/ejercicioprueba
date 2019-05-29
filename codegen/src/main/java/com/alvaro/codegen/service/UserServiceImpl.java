package com.alvaro.codegen.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvaro.codegen.repository.UserRepository;
import com.example.generated.model.User;
import com.example.generated.model.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository userRepository;

	@Override
	public User findById(Integer userId) {
	User user = userRepository.getOne(userId);
	return user;
	}

	@Override
	public void createUser(User user) {
	userRepository.save(user);
	}

	@Override
	public void updateUser(Integer userId, User user) {	
	
	User userUpdate = userRepository.getOne(userId);
	
	userUpdate = userRepository.save(user);
	
	}

	@Override
	public void deleteUser(Integer userId) {
	User userDelete = userRepository.getOne(userId);
	userRepository.delete(userDelete);
	}

	@Override
	public UserResponse findAll() {
	List<User> users = userRepository.findAll();
	UserResponse usersResponse = (UserResponse) users;
	return usersResponse;
	}
}
