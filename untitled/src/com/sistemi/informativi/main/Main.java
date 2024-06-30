package com.sistemi.informativi.main;

import com.sistemi.informativi.builder.User;
import com.sistemi.informativi.dao.MockDAO;
import com.sistemi.informativi.dao.MockDaoImpl;

public class Main {
    public static void main(String[] args) {
        User user = new User.UserBuilder("Mario","Rossi").build();

        MockDAO mockDAO = new MockDaoImpl();
        mockDAO.addUser(user);
    }
}
