package com.project.demo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;



public interface UserRepository extends MongoRepository<User, String> {

    @Query("{userId:'?0'}")
    User findUserById (String user_id);

    User findByUserName(String userName);

    public long count();
}
