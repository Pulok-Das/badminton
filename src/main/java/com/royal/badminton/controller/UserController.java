package com.royal.badminton.controller;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.royal.badminton.model.User;
import com.royal.badminton.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> readUser() {
        return userService.getUser();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User readUserById(@PathVariable(value = "id") Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/mobile/{mobile}", method = RequestMethod.GET)
    public User readUserById(@PathVariable(value = "mobile") String mobile) {
        return userService.getMobile(mobile);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public User readUser(@PathVariable(value = "id") Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }
}
