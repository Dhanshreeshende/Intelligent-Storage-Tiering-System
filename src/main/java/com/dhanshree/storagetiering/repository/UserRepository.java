package com.dhanshree.storagetiering.repository;

import com.dhanshree.storagetiering.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByEmail(String email);

}