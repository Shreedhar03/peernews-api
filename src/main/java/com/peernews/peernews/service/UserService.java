package com.peernews.peernews.service;

import com.peernews.peernews.model.User;
import com.peernews.peernews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        // Additional validation or business logic can be added here if needed
        System.out.println("User created successfully");
        return userRepository.save(user);
    }

    public User updateUser(String id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            // Update user fields with values from updatedUser
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());

            // Save the updated user
            return userRepository.save(existingUser);
        }
        // Return null if user with given id doesn't exist
        return null;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
