package com.sg.microservice.entity;

import java.io.Serializable;
//import javax.persistence.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//import lombok.NonNull;
//import lombok.AllArgsConstructor;
//import lombok.Getter;

/**
 * The persistent class for the User database table.
 * 
 */
//@Entity
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
//@Table(name="User")

// lombok annotations
@Data
//empty constructor generation.
@NoArgsConstructor
@ToString

// getter and setter lombok annotation seems not working with eclipse debuging
//@Getter 
//@Setter
//jika tanpa ini maka disimpan di collection user (not capitalized)
@Document(collection = "User") 
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Setter(value=AccessLevel.PROTECTED)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="user_id")
	private String userId;
	//@Column(name="age")
	private int age;
	//@Column(name="name")
	private String name;
	//@Column(name="salary")
	private float salary;
	@Indexed(unique = true)
	private String email;

	// no constructor and getter setter, all handled by lombok 
}