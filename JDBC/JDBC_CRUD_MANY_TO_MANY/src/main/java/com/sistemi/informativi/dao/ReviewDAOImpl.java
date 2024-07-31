package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.ReviewDTO;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.ReviewVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAOImpl implements ReviewDAO{

    @Override
    public void addReview(ReviewDTO reviewDTO) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(SqlScript.sqlReviewInsert);
        preparedStatement.setString(1,reviewDTO.getLocation());
        preparedStatement.setInt(2,reviewDTO.getCourseID());
        preparedStatement.executeUpdate();
    }

    @Override
    public ArrayList<ReviewVO> getReviewLocationByCourse(int courseId) throws SQLException, ClassNotFoundException {

        ArrayList<ReviewVO> reviews = new ArrayList<>();
        ReviewVO reviewVO;
        /*
        Quando occorre eseguire delle query (operazioni di lettura) parametriche
        è necessario utilizzare l'Oggetto PreparedStatement in quanto occorre sostituire
        concretamente i placeholder, e lo si può fare solo tramite l'API Prepared Statement
        che rende possibile concretizzare i placeholde tramite i metodi di set
        (l'API Statement non ha i metodi di set, per cui non è utilizzabile per sostituire
        i placeholder in na query parametrica)

        BEST PRACTICE :
        utilizzare l'API Statement per query che non contengono parametri (letture integrali)
        utilizzare l'API PreparedStatement per query parametriche*/

        PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(SqlScript.sqlReviewsLocationByCourse);
        preparedStatement.setInt(1,courseId);

        /*
        Invocando il metodo executeQuery su un PreparedStatement già concreto si ricava un
        ResultSet contenete già i risultati della lettura
         */
        ResultSet resultSet1 = preparedStatement.executeQuery();
        resultSet1 = preparedStatement.executeQuery();

        while(resultSet1.next()){
            reviewVO = new ReviewVO(resultSet1.getString("Location"));
            reviews.add(reviewVO);
        }
        return reviews;
    }
}
