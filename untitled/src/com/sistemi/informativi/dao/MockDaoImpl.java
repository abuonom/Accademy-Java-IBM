package com.sistemi.informativi.dao;

import com.sistemi.informativi.builder.User;

import java.util.Date;

public class MockDaoImpl implements MockDAO{
    @Override
    public void addUser(User user) {
        /*
        Lo user, arriverà dal main costruito con FirstName e LastName
        il DAO si occuperà di settare il RegistrationDate
         */
        User newUser =
                new User.UserBuilder(user.getFirstName(), user.getLastName())
                        .setRegistrationDate(new Date(2019,22,12)).build();
        System.out.println(newUser);
    }
}
