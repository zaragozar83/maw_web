package com.coffee.maqzar.controller;

import com.coffee.maqzar.domain.User;
import com.coffee.maqzar.service.IUserService;
import com.coffee.maqzar.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by exrzaragoza on 28/11/2016.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping
    public String showUsers(Model model){
        List<User> listUsers = new ArrayList<User>();
        listUsers = userService.getAllUsers();
        System.out.println(listUsers.size());
        model.addAttribute("users", listUsers);
        return "users";
    }

    @RequestMapping("/lastName/{lastName}")
    public String showUsersByLastName(Model model, @PathVariable("lastName")String lastName){
        model.addAttribute("users", userService.findUserByLastName(lastName));
        return "users";
    }

    @RequestMapping("/name/{name}")
    public String showUsersByName(Model model, @PathVariable("name")String name){
        model.addAttribute("users", userService.findUserByName(name));
        return "users";
    }
}
