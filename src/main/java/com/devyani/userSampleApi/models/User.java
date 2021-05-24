package com.devyani.userSampleApi.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User {
    private int id;
    @NotBlank(message = "FirstName must not be blank.")
    @NotEmpty(message = "FirstName must not be empty.")
    @Size(min = 2, max = 32, message = "FirstName must be between 2 and 32 characters long")
    private String firstName;
    @NotBlank(message = "LastName must not be blank.")
    @NotEmpty(message = "LastName must not be empty.")
    @Size(min = 2, max = 32, message = "LastName must be between 2 and 32 characters long")
    private String lastName;
    private String phoneNumber;
    private String email;

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, String firstName, String lastName, String phoneNumber, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
