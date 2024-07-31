package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.ProductDTO;
import com.sistemi.informativi.sql.SqlScript;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAOImpl implements ProductDAO{

    @Override
    public int addProduct(ProductDTO productDTO) throws SQLException, ClassNotFoundException {

        int id = -1;
        PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(SqlScript.sqlProductInsert);
        preparedStatement.setString(1, productDTO.getName());
        preparedStatement.setFloat(2, productDTO.getPrice());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;

    }
}
