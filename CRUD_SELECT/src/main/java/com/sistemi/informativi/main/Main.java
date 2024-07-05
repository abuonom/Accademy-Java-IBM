package com.sistemi.informativi.main;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dao.StudentDAO;
import com.sistemi.informativi.dao.StudentDAOImpl;
import com.sistemi.informativi.dto.StudentDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //richiesta apertura connessione
        Connection connection = ConnectionManager.getConnection();

        //test inserimento
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.addStudent(new StudentDTO("Alice", "Verdini", 22));
        studentDAO.addStudent(new StudentDTO("Alessio", "Buonomo", 25));
        studentDAO.addStudent(new StudentDTO("Adriana", "Acampa", 24));
        //test update
        studentDAO.updateStudent(new StudentDTO("Alice", "Verdini", 30), 1);
        //test remove
        studentDAO.removeStudent(2);
        //test get
        studentDAO.getStudents().forEach(System.out::println);
    }
}
