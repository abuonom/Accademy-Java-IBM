package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.CourseDTO;
import com.sistemi.informativi.dto.ReviewDTO;
import com.sistemi.informativi.vo.ReviewVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FacedeDAOImpl implements FacedeDAO{

    CourseDAO courseDAO = new CourseDAOImpl();
    ReviewDAO reviewDAO = new ReviewDAOImpl();

    @Override
    public void addReview(ReviewDTO reviewDTO) throws SQLException, ClassNotFoundException {
       reviewDAO.addReview(reviewDTO);
    }

    @Override
    public ArrayList<ReviewVO> getReviewLocationByCourse(int courseId) throws SQLException, ClassNotFoundException {
        return reviewDAO.getReviewLocationByCourse(courseId);
    }

    @Override
    public int addCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException {
        return courseDAO.addCourse(courseDTO);
    }

    @Override
    public void removeCourse(int id) throws SQLException, ClassNotFoundException {
        courseDAO.removeCourse(id);
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return ConnectionManager.getConnection();
    }

    @Override
    public void closeConnection() throws SQLException {
        ConnectionManager.closeConnection();
    }
}
