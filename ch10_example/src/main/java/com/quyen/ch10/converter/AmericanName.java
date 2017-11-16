package com.quyen.ch10.converter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("lincoln")
public class AmericanName {
    @Value("Abraham")
    private String firstName;

    @Value("Lincoln")
    private String lastName;

    public AmericanName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AmericanName() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "AmericanName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
