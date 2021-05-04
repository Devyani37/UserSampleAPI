package com.devyani.userSampleApi.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {


    public void readingCSVFile() {
        BufferedReader reader;

        {
            try {
                reader = new BufferedReader(new FileReader("/Users/devyani/Downloads/UserSampleData - Sheet1.csv"));
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                    if (line != null) {
                        String[] arr = line.split(",");
                    }
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}


