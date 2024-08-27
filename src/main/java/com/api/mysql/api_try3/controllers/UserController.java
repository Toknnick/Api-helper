package com.api.mysql.api_try3.controllers;

import com.api.mysql.api_try3.models.User;
import com.api.mysql.api_try3.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/get/{login}")
    public User getUserDetails(@PathVariable("login") String login) {
        return userService.getUser(login);
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) {
        if(userService.getUser(user.getLogin()) != null) {
            return "User already exists. Try another login.";
        }else {
            userService.createUser(user);
            return "User created successfully";
        }
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) {
        if(userService.getUser(user.getLogin()) != null) {
            userService.updateUser(user);
            return "User updated successfully";
        }else{
            return "User does not exist";
        }
    }
}
