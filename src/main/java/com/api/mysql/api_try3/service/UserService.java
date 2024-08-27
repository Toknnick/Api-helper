package com.api.mysql.api_try3.service;

import com.api.mysql.api_try3.models.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User updateUser(User user);
    public String deleteUser(String login);
    public User getUser(String login);
}
