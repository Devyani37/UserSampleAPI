package com.devyani.userSampleApi;

import com.devyani.userSampleApi.services.ReadCSV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class UserSampleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserSampleApiApplication.class, args);
		ReadCSV readCSV = new ReadCSV();
		readCSV.readingCSVFile();


	}

}
