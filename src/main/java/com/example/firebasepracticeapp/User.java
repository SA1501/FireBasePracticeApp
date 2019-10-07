package com.example.firebasepracticeapp;

import android.net.Uri;
import android.widget.ImageView;

import java.net.URI;

public class User {

    String firstName;
    String lastName;
    String jobTitleName;
    String phoneNumber;
    String emailAddress;
    String preferredFullName;

    @Override
    public String toString() {
                return firstName + " " + lastName ;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setJobTitleName(String jobTitleName) {
        this.jobTitleName = jobTitleName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPreferredFullName(String preferredFullName) {
        this.preferredFullName = preferredFullName;
    }
}

