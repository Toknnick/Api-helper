package com.api.mysql.api_try3.service.imlp;

import com.api.mysql.api_try3.models.User;
import com.api.mysql.api_try3.repository.UserRepository;
import com.api.mysql.api_try3.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String deleteUser(String login) {
        userRepository.deleteById(login);
        return "Success";
    }

    @Override
    public User getUser(String login) {
        return userRepository.findById(login).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
