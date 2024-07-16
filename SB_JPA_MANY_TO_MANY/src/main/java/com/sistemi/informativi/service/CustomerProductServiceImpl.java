package com.sistemi.informativi.service;

import com.sistemi.informativi.entity.Customer;
import com.sistemi.informativi.entity.Product;
import com.sistemi.informativi.repository.CustomerProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CustomerProductServiceImpl implements CustomerProductService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${add.success.message}")
    private String addSuccessMessage;

    @Value("${add.error.message}")
    private String addErrorMessage;

    @Value("${get.error.message}")
    private String getErrorMessage;

    private CustomerProductRepository customerProductRepository;

    public CustomerProductServiceImpl(CustomerProductRepository customerProductRepository) {
        this.customerProductRepository = customerProductRepository;
    }

    @Override
    public void checkAddCustomer(Customer customer) {
        try {
            customerProductRepository.addCustomer(customer);
            log.info(addSuccessMessage);
        }catch (Exception e) {
            log.error(addErrorMessage);
            e.printStackTrace();
        }
    }

    @Override
    public void checkAddProduct(Product product) {
        try {
            customerProductRepository.addProduct(product);
            log.info(addSuccessMessage);
        }catch (Exception e) {
            log.error(addErrorMessage);
            e.printStackTrace();
        }
    }

    @Override
    public void checkGetCustomersByProductId(int productId) {
        try {
            customerProductRepository.getCustomersByProductId(productId).forEach(customer -> log.info(customer.toString()));;
        }catch (Exception e) {
            log.error(getErrorMessage);
            e.printStackTrace();
        }
    }
}
