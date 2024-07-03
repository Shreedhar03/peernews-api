package com.peernews.peernews.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.peernews.peernews.models.News;


public interface NewsRepo extends MongoRepository<News, String> {
    
}
