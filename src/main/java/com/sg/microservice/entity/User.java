package com.sg.microservice.entity;

import java.io.Serializable;
//import javax.persistence.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * The persistent class for the User database table.
 * 
 */
//@Entity
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
//@Table(name="User")

//jika tanpa ini maka disimpan di collection user (not capitalized)
@Document(collection = "User") 
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="user_id")
	private int userId;
	//@Column(name="age")
	private int age;
	//@Column(name="name")
	private String name;
	//@Column(name="salary")
	private float salary;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return this.salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}