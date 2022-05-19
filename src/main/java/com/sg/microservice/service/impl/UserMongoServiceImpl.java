package com.sg.microservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.microservice.entity.User;
import com.sg.microservice.exception.EntityNotFoundException;
import com.sg.microservice.repository.UserMongoRepository;
import com.sg.microservice.service.UserMongoService;

@Service
public class UserMongoServiceImpl implements UserMongoService{
	@Autowired
	private UserMongoRepository userMongoRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userMongoRepository.findAll();
	}

	@Override
	public User getUserById(String id) {
		return userMongoRepository.findById(id).orElse(null);
	}

	@Override
	public User addOrUpdateUser(User user) {
		return userMongoRepository.save(user);
	}

	@Override
	public User deleteUser(String id) throws Exception {
		User tobeDeleted = null;
		tobeDeleted = userMongoRepository.findById(id).orElse(null);
		if(tobeDeleted != null) {
			userMongoRepository.deleteById(id);
		}else {
			throw new EntityNotFoundException("user not available");
		}
		return tobeDeleted;
	}

}
