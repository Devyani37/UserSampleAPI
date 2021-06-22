package com.devyani.userSampleApi.repositories;

import com.devyani.userSampleApi.models.User;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadCSV {

    private final static String CSV_FILE_NAME = "/Users/devyani/Downloads/UserSampleData - Sheet1.csv";

    public List<User> readingCSVFile() {
        List<User> userList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_NAME))) {

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

    public void appendToCSV(User user) {

        String data = String.join(",", String.valueOf(user.getId()), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail());

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_NAME, true))) {

            bw.write(data);
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeToCSV(List<User> userList) {

        //Truncate file.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE_NAME))) {

            bw.write("ID,First Name,Last Name,Phone Number,Email");
            bw.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        userList.forEach(user -> appendToCSV(user));

    }

}


