package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.CourseDTO;
import com.sistemi.informativi.sql.SqlScript;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDAOImpl implements CourseDAO{

    /**
     *
     * @param courseDTO
     * @return il valore della chiave primaria generata dopo l'inserimento
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public int addCourse(CourseDTO courseDTO) throws SQLException, ClassNotFoundException {
        int id = 0;
        PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(SqlScript.sqlCourseInsert);
        preparedStatement.setString(1,courseDTO.getTitle());
        preparedStatement.executeUpdate();

        /*
        Il metodo getGenerateKeys restituisce una struttura dati JDBC
        che contiene una sola locazione di memoria nella quale è
        contenuta l'ultima chiave primaria generata
         */
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if(resultSet.next()){
            id = resultSet.getInt(1);
        }
        return id;
    }

    @Override
    public void removeCourse(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(SqlScript.sqlDeleteCourse);
        preparedStatement.setInt(1,id);
        preparedStatement.executeUpdate();
    }
}
