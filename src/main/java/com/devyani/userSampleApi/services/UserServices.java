package com.devyani.userSampleApi.services;

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
        csvReader.appendToCSV(newUser);

        return true;

    }

    public void updateUserById(int id, User updatedUserData){
        List<User> userList = getAllUsers();
        User existingUser = null;
        boolean isUserExist = false;

        for(User user: userList){
            if(user.getId() == id){
                isUserExist = true;
                existingUser = user;
                break;
            }
        }

        if(!isUserExist){
            throw new IllegalArgumentException("User with this id is not present");
        }

        existingUser.setFirstName(updatedUserData.getFirstName());
        existingUser.setLastName(updatedUserData.getLastName());
        existingUser.setPhoneNumber(updatedUserData.getPhoneNumber());
        existingUser.setEmail(updatedUserData.getEmail());

        csvReader.writeToCSV(userList);


    }

    public void deleteById(int id){
        List<User> userList = getAllUsers();
        List<User> newUserList = new ArrayList<>();
        boolean isUserExist = false;

        for(User user: userList){
            if(user.getId() == id){
                isUserExist = true;
                break;
            }else {
                newUserList.add(user);
            }
        }
        if(!isUserExist){
            throw new InvalidRequestException("User with this id is not present");
        }

        csvReader.writeToCSV(newUserList);
    }

}

