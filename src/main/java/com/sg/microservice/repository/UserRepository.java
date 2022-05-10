package com.sg.microservice.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sg.microservice.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

}
