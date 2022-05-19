package com.sg.microservice.springbootgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {
		"com.sg.microservice"
		})
//@EnableJpaRepositories(basePackages = {"com.sg.microservice"})
@EnableMongoRepositories(basePackages = {"com.sg.microservice"})
@EntityScan(basePackages = {"com.sg.microservice"}) 
public class SpringbootGradleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootGradleApplication.class, args);
	}

}
