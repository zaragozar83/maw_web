package com.coffee.maqzar.service.impl;

import com.coffee.maqzar.domain.User;
import com.coffee.maqzar.repository.IUserRepository;
import com.coffee.maqzar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public User findUserById(Long userId) {
        return userRepository.findUserById(userId);
    }

    @Override
    public List<User> findUserByLastName(String lastName) {
        return userRepository.findUserByLastName(lastName);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }
}
