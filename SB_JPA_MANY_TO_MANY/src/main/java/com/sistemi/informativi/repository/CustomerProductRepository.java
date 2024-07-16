package com.sistemi.informativi.repository;

import com.sistemi.informativi.entity.Customer;
import com.sistemi.informativi.entity.Product;

import java.util.List;

public interface CustomerProductRepository {
    public void addCustomer(Customer customer);
    public void addProduct(Product product);
    public List<Customer> getCustomersByProductId(int productId);
}
