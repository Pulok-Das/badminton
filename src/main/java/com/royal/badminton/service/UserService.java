package com.royal.badminton.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.royal.badminton.model.User;
import com.royal.badminton.repository.UserRepository;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    // CREATE
    public User createUser(User user) {
        return userRepository.save(user);
    }
    // READ ALL
    public List<User> getUser() {
        return userRepository.findAll();
    }
    // READ by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
     }
    //Read by Mobile
    public User getMobile(String mobile) {
        return userRepository.findByMobile(mobile).get();
     }
    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).get();
        user.setName(userDetails.getName());
        user.setMobile(userDetails.getMobile());
        return userRepository.save(user);
    }
    
}
