package com.peernews.peernews.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peernews.peernews.repositories.UserRepo;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;
    @GetMapping("/")
    public ResponseEntity<?> getUsers(){
        return ResponseEntity.ok(this.userRepo.findAll());
    }    
}
