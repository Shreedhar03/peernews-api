package com.peernews.peernews.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.peernews.peernews.models.User;

public interface UserRepo extends MongoRepository<User, String> {

}
