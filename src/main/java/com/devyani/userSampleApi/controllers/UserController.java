package com.devyani.userSampleApi.controllers;

import com.devyani.userSampleApi.models.User;
import com.devyani.userSampleApi.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
public class UserController {

    @Autowired
    UserServices userServices;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userServices.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") @Min(value = 1, message = "Id must be greater than zero.") Integer id) {

        return userServices.getUserById(id);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public boolean addUser(@RequestBody @Valid User newUser) {
        return userServices.addUser(newUser);
    }

    @RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT)
    public void updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        userServices.updateUserById(id, user);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE )
    public void deleteById(@PathVariable("id") Integer id){
        userServices.deleteById(id);
    }




}
