package com.sistemi.informativi;

import java.io.*;
import java.sql.SQLException;

import com.sistemi.informativi.dao.StudentDAO;
import com.sistemi.informativi.dao.StudentDAOImpl;
import com.sistemi.informativi.dto.StudentDTO;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "registration", value = "/registration")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentDAO studentDAO = new StudentDAOImpl();
        StudentDTO studentDTO =
                new StudentDTO(request.getParameter("firstname"), request.getParameter("lastname"),Integer.parseInt(request.getParameter("age")));
        try {
            studentDAO.addStudent(studentDTO);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
    }
    public void destroy() {
    }
}