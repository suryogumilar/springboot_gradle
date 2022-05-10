package com.sg.microservice.service;

import java.util.List;

import com.sg.microservice.entity.User;

public interface UserService {
	public List<User> getAllUsers();
	public User getUserById(Integer id);
	public User addOrUpdateUser(User user);
	public User deleteUser(Integer id) throws Exception;
}
