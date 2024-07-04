package com.sistemi.informativi.dao;

import com.sistemi.informativi.dto.*;
import com.sistemi.informativi.vo.CustomerVO;
import com.sistemi.informativi.vo.ReviewVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FacedeDAO {
    void addReview(ReviewDTO reviewDTO) throws SQLException, ClassNotFoundException;

    ArrayList<ReviewVO> getReviewLocationByCourse(int courseId) throws SQLException, ClassNotFoundException;
    int addCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException;
    void removeCourse(int id) throws SQLException, ClassNotFoundException;
    Connection getConnection() throws ClassNotFoundException, SQLException;
    void closeConnection() throws SQLException;
    int addCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException;
    ArrayList<CustomerVO> getCustomersNameByProduct(int productId) throws ClassNotFoundException, SQLException;
    int addProduct(ProductDTO productDTO) throws ClassNotFoundException, SQLException;
    void addCustomerProduct(CustomerProductDTO customerProductDTO) throws ClassNotFoundException, SQLException;
}
