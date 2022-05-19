package com.sg.microservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sg.microservice.entity.User;
@Repository
public interface UserMongoRepository extends MongoRepository<User, String>{

}
