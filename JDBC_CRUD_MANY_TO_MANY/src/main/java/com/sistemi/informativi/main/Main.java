package com.sistemi.informativi.main;

import com.sistemi.informativi.dao.FacedeDAO;
import com.sistemi.informativi.dao.FacedeDAOImpl;
import com.sistemi.informativi.dto.*;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        FacedeDAO facedeDAO = new FacedeDAOImpl();
        Connection con = facedeDAO.getConnection();

        int customerId1 = facedeDAO.addCustomer(new CustomerDTO("Gioele","gioelemarini@gmail.com"));
        int customerId2 =  facedeDAO.addCustomer(new CustomerDTO("Teresa","teresaproto@libero.it"));

        int productId1 = facedeDAO.addProduct(new ProductDTO("TV",367.89f));
        int productId2 = facedeDAO.addProduct(new ProductDTO("Telefono",360f));
        facedeDAO.addCustomerProduct(new CustomerProductDTO(customerId1,productId1));
        facedeDAO.addCustomerProduct(new CustomerProductDTO(customerId1,productId2));

        facedeDAO.addCustomerProduct(new CustomerProductDTO(customerId2,productId1));
        facedeDAO.addCustomerProduct(new CustomerProductDTO(customerId2,productId2));

        //TEST QUERY JOIN
        facedeDAO.getCustomersNameByProduct(productId1)
                .forEach(customer -> System.out.println(customer.getName()));
        facedeDAO.closeConnection();
    }
}