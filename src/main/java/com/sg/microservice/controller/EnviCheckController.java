package com.sg.microservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.microservice.entity.User;

@RestController
@RequestMapping("/envi")
public class EnviCheckController {
	@GetMapping("/all")
	public ResponseEntity<Map<String, String>>getAllEnvi(){
		Map<String, String> getenv = System.getenv();
		
		return new ResponseEntity<Map<String,String>>(getenv, HttpStatus.OK);
	}
}
