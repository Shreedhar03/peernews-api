package com.peernews.peernews.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peernews.peernews.models.News;
import com.peernews.peernews.repositories.NewsRepo;

// allow origin
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsRepo newsRepo;

    // get all news
    @GetMapping("")
    //   news and count of the news
    public ResponseEntity<?> getNews(){
        List<News> news = newsRepo.findAll();
        int count = news.size();
        
        Map<String, Object> response = new HashMap<>();
        response.put("news", news);
        response.put("count", count);
        
        return ResponseEntity.ok(response);
    }
    // login
    @PostMapping("/create")
    public ResponseEntity<?> createNews(@RequestBody Map<String, String> news){
        // create a news
        News newArticle = new News(news.get("title"), news.get("content"));
        News savedArticle = newsRepo.save(newArticle);
        return ResponseEntity.ok(savedArticle);
        
    }
}
