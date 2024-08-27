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
    public User createUser(@RequestBody User user) {
        if(userService.getUser(user.getLogin()) != null) {
            return null;
        }else {
            userService.createUser(user);
            return user;
        }
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        if(userService.getUser(user.getLogin()) != null) {
            userService.updateUser(user);
            return user;
        }else{
            return null;
        }
    }


    @DeleteMapping("/delete/{login}")
    public String deleteUser(@PathVariable("login") String login) {
        if(userService.getUser(login) != null) {
            userService.deleteUser(login);
            return "User deleted successfully";
        }else{
            return "User does not exist";
        }
    }
}
