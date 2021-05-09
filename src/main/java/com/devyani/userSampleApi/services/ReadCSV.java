package com.devyani.userSampleApi.services;

import com.devyani.userSampleApi.models.User;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadCSV {

    public List<User> readingCSVFile() {
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/devyani/Downloads/UserSampleData - Sheet1.csv"))) {

            String line = reader.readLine();
            int row = 0;
            while (line != null) {
                if (row > 0) {
                    String[] arr = line.split(",");
                    User user = new User(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4]);
                    userList.add(user);

                }
                line = reader.readLine();
                row++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return userList;

    }

}


