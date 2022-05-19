package com.sg.microservice.springbootgradle;

import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;


/*
 * class ini opsional untuk ditambahkan ke package
 * */
@Component
public class MyMongoFactoryBean {
	private final MongoDatabaseFactory mongo;
	public MyMongoFactoryBean(MongoDatabaseFactory mongo) {
        this.mongo = mongo;
        System.out.println(mongo);
    }
	public MongoDatabaseFactory getMongo() {
		return mongo;
	}
}
