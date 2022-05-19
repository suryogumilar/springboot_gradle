package com.sg.microservice.service;

import java.util.List;

import com.sg.microservice.entity.User;

public interface UserMongoService {
	public List<User> getAllUsers();
	public User getUserById(String id);
	public User addOrUpdateUser(User user);
	public User deleteUser(String id) throws Exception;
}
