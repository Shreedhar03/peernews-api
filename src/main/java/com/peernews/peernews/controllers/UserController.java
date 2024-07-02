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

import com.peernews.peernews.models.User;
import com.peernews.peernews.repositories.UserRepo;

// allow origin
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    // get all users
    @GetMapping("")
    //   users and count of the users
    public ResponseEntity<?> getUsers(){
        List<User> users = userRepo.findAll();
        int count = users.size();
        
        Map<String, Object> response = new HashMap<>();
        response.put("users", users);
        response.put("count", count);
        
        return ResponseEntity.ok(response);
    }

    // create a new user
    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user){

        User newUser = this.userRepo.save(user);
        return ResponseEntity.ok(newUser);
    }

    // login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> credentials){
        String username = credentials.get("username");
        String password = credentials.get("password");
        User user = userRepo.findByUsername(username);
        if(user == null){
            return ResponseEntity.ok("User not found");
        }
        if(user.getPassword().equals(password)){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok("Invalid password");
    }
}
