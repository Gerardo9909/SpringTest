package com.exam.springtest.service;

import com.exam.springtest.model.User;
import com.exam.springtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        if (userRepository.findUserByLogin(user.getLogin()).isPresent()) {
            return null;
        } else {
            return userRepository.save(user);
        }
    }

    public User modifyUser(User user) {
        if (userRepository.findUserByLogin(user.getLogin()).isPresent()) {
            return userRepository.save(user);
        } else {
            return null;
        }
    }
}
