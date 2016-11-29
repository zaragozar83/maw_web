package com.coffee.maqzar.service;

import com.coffee.maqzar.domain.User;

import java.util.List;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
public interface IUserService {

    public List<User> getAllUsers();
    public User findUserById(Long userId);
    public List<User> findUserByLastName(String lastName);
    public List<User> findUserByName(String name);
}
