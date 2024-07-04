package com.sistemi.informativi.main;

import com.sistemi.informativi.dao.FacedeDAO;
import com.sistemi.informativi.dao.FacedeDAOImpl;
import com.sistemi.informativi.dto.CourseDTO;
import com.sistemi.informativi.dto.ReviewDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        FacedeDAO facedeDAO = new FacedeDAOImpl();
        Connection con = facedeDAO.getConnection();

        int id = facedeDAO.addCourse(new CourseDTO("React"));
        facedeDAO.addReview(new ReviewDTO("Florence",id));
        facedeDAO.addReview(new ReviewDTO("Naples",id));

        facedeDAO.getReviewLocationByCourse(id).forEach(System.out::println);
        facedeDAO.closeConnection();
    }
}