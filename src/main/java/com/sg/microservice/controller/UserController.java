package com.sg.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sg.microservice.entity.User;
import com.sg.microservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/allusers")
	public ResponseEntity<List<User>>getAllUsers(){
		List<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<User>getUserById(@PathVariable("id") int userId){
		
		User userById = userService.getUserById(userId);
		return new ResponseEntity<User>(userById, HttpStatus.OK);
	}
	
	@PostMapping("/addOrUpdate")
	public ResponseEntity<User>addOrUpdate(@RequestBody User user){
		
		User userById = userService.addOrUpdateUser(user);
		return new ResponseEntity<User>(userById, HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<User>deleteUser(@RequestParam("id") int id) throws Exception{
		
		User userById = userService.deleteUser(id);
		return new ResponseEntity<User>(userById, HttpStatus.OK);
	}
}
