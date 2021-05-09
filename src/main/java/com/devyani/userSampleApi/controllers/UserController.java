package com.devyani.userSampleApi.controllers;

import com.devyani.userSampleApi.models.User;
import com.devyani.userSampleApi.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserServices userServices;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userServices.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Integer id) {

        return userServices.getUserById(id);
    }


}
