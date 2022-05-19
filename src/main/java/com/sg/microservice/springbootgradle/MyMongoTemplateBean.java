package com.sg.microservice.springbootgradle;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;


/*
 * class ini opsional untuk ditambahkan ke package
 * */
@Component
public class MyMongoTemplateBean {
	private final MongoTemplate mongoTemplate;
	
	public MyMongoTemplateBean(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
        System.out.println(mongoTemplate);
	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
}
