package com.api.mysql.api_try3.service.imlp;

import com.api.mysql.api_try3.models.Room;
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
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        User existingUser = userRepository.findById(user.getLogin()).orElse(new User());
        existingUser.setLogin(user.getLogin() != null ? user.getLogin() : existingUser.getLogin());
        existingUser.setPassword(user.getPassword() != null ? user.getPassword() : existingUser.getPassword());
        existingUser.setOwnRoom(user.getOwnRoom() != null ? user.getOwnRoom() : existingUser.getOwnRoom());
        existingUser.setAvailableRooms(user.getAvailableRooms() != null ? user.getAvailableRooms() : existingUser.getAvailableRooms());
        userRepository.save(existingUser);
        return user;
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
}
