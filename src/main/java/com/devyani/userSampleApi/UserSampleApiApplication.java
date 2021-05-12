package com.devyani.userSampleApi;

import com.devyani.userSampleApi.models.User;
import com.devyani.userSampleApi.services.ReadCSV;
import com.devyani.userSampleApi.services.UserServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class UserSampleApiApplication {

	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(UserSampleApiApplication.class, args);
		//ReadCSV readCSV = new ReadCSV();
		//readCSV.readingCSVFile();
//	UserServices userServices = app.getBean(UserServices.class);
//
//		System.out.println(userServices.getUserById(3));
//		User newUser = new User();
//		newUser.setId(2);
//		newUser.setFirstName("dev");
//		newUser.setLastName("peeyush");
//		newUser.setPhoneNumber("324411");
//		newUser.setEmail("orchid.plant@gmail.com");
//		//userServices.addUser(newUser);
//		userServices.updateUserById(4,newUser);
//
//
	//	userServices.deleteById(5);
	//	userServices.getAllUsers().forEach(user -> System.out.println(user));

	}

}
