package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Customer;
import com.sistemi.informativi.entity.Product;

public interface CustomerProductService {
    public void checkAddCustomer(Customer customer);
    public void checkAddProduct(Product product);
    public void checkGetCustomersByProductId(int productId);
}
