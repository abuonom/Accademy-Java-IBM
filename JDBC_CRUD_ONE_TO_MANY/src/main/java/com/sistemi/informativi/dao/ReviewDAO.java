package com.sistemi.informativi.dao;

import com.sistemi.informativi.dto.ReviewDTO;
import com.sistemi.informativi.vo.ReviewVO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ReviewDAO {
    public Connection addReview(ReviewDTO reviewDTO) throws SQLException, ClassNotFoundException;
    public ArrayList<ReviewVO> getReviewLocationByCourse(int courseId) throws SQLException, ClassNotFoundException;
}
