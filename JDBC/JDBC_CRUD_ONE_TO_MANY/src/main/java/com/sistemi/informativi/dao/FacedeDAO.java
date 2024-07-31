package com.sistemi.informativi.dao;

import com.sistemi.informativi.dto.CourseDTO;
import com.sistemi.informativi.dto.ReviewDTO;
import com.sistemi.informativi.vo.ReviewVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FacedeDAO{
    public void addReview(ReviewDTO reviewDTO) throws SQLException, ClassNotFoundException;
    public ArrayList<ReviewVO> getReviewLocationByCourse(int courseId) throws SQLException, ClassNotFoundException;
    public int addCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException;
    void removeCourse(int id) throws SQLException, ClassNotFoundException;
    public Connection getConnection() throws ClassNotFoundException, SQLException;
    public void closeConnection() throws SQLException;
    }
