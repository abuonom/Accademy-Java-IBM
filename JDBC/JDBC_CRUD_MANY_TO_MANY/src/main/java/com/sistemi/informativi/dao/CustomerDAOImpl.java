package com.sistemi.informativi.dao;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.CustomerDTO;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.CustomerVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO{
    @Override
    public int addCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        int id = -1;
        PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(SqlScript.sqlCustomerInsert);
        preparedStatement.setString(1, customerDTO.getName());
        preparedStatement.setString(2, customerDTO.getEmail());
        preparedStatement.executeUpdate();

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
            id = resultSet.getInt(1);
        }
        return id;
    }

    @Override
    public ArrayList<CustomerVO> getCustomersNameByProduct(int productId) throws SQLException, ClassNotFoundException {

        ArrayList<CustomerVO> customers = new ArrayList<>();
        CustomerVO customerVO;

        PreparedStatement preparedStatement = ConnectionManager.getPreparedStatement(SqlScript.sqlCustomersNameByProduct);
        preparedStatement.setInt(1,productId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            customerVO = new CustomerVO(resultSet.getString("name"));
            customers.add(customerVO);
        }
        return customers;
    }
}
