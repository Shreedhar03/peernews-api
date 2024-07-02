package com.peernews.peernews.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    
    // constructor
    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // getters and setters
    public String getUsername() {
        return username;
    }
    public String getfirstName() {
        return firstName;
    }
    public String getlastName() {
        return lastName;
    }
    public String getPassword() {
        return password;
    }
}
