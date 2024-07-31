package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.CustomerProductDTO;
import com.sistemi.informativi.sql.SqlScript;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerProductDAOImpl implements CustomerProductDAO{

    @Override
    public void addCustomerProduct(CustomerProductDTO customerProductDTO) throws SQLException, ClassNotFoundException {
        int id = 0;
        PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(SqlScript.sqlJoinInsert);
        preparedStatement.setInt(1,customerProductDTO.getCustomerId());
        preparedStatement.setInt(2,customerProductDTO.getProductId());
        preparedStatement.executeUpdate();
    }
}
