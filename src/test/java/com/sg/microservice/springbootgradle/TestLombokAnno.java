package com.sg.microservice.springbootgradle;

import org.junit.jupiter.api.Test;

import com.sg.microservice.entity.User;

public class TestLombokAnno {

	@Test
	public void givenAnnotatedUser_thenHasGettersAndSetters() {
		User user = new User();
		user.setEmail("tes");
		System.out.println(user);
		System.out.println(user.getUserId());
		// user.setUserId("sasa"); // protected
	}
}
