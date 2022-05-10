package com.sg.microservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.microservice.entity.User;
import com.sg.microservice.repository.UserRepository;
import com.sg.microservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public User addOrUpdateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User deleteUser(Integer id) throws Exception {
		User tobeDeleted = null;
		tobeDeleted = userRepository.findById(id).orElse(null);
		if(tobeDeleted != null) {
			userRepository.deleteById(id);
		}else {
			throw new Exception("user not available");
		}
		return tobeDeleted;
	}

}
