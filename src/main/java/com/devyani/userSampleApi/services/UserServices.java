package com.devyani.userSampleApi.services;

import com.devyani.userSampleApi.exceptions.BadRequestException;
import com.devyani.userSampleApi.exceptions.InvalidRequestException;
import com.devyani.userSampleApi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServices {

    @Autowired
    private ReadCSV csvReader;

    public List<User> getAllUsers() {
        return csvReader.readingCSVFile();
    }

    public User getUserById(int id){

       List<User> userList = getAllUsers();


        for(User user : userList){
            if(user.getId() == id){
                return user;
            }
        }
        throw new InvalidRequestException("User is not present");

    }

    public boolean addUser(User newUser){
        List<User> userList = getAllUsers();
        for(User user : userList){
            if(user.getId() == newUser.getId()){
                throw new InvalidRequestException("User is already present");
            }

        }
        userList.add(newUser);

        return true;

    }

}

