package com.sistemi.informativi.builder;

import java.util.Date;

//OUTER CLASS
public class User {

    //INFO STRUTTURA INIZIALE
    private String firstName;
    private String lastName;
    //INFRO STRUTTURA "AUGMENTED"
    private Date registrationDate;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.registrationDate = builder.registrationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }


    //INNER CLASS
    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private Date registrationDate;

        public UserBuilder setRegistrationDate(Date registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }


        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public User build() {
            return new User(this);
        }
    }
}
