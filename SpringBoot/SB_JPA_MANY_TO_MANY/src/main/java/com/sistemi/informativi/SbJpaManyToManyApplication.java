package com.sistemi.informativi;

import com.sistemi.informativi.entity.Customer;
import com.sistemi.informativi.entity.Product;
import com.sistemi.informativi.service.CustomerProductService;
import com.sistemi.informativi.service.CustomerProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SbJpaManyToManyApplication implements CommandLineRunner {

    private CustomerProductService customerProductService;

    public SbJpaManyToManyApplication(CustomerProductService customerProductService) {
        this.customerProductService = customerProductService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SbJpaManyToManyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Customer customer = new Customer("Maria Russo","mrusso@libero.it");
        Customer customer1 = new Customer("Giulio Proto","gproto@gmail.com");
        Product product = new Product("PC",1234.78f);
        Product product1 = new Product("Tablet",678.90f);

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        customerList.add(customer1);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);

        customer.setProductList(productList);
        customer1.setProductList(productList);
        product1.setCustomerList(customerList);
        product.setCustomerList(customerList);

        customerProductService.checkAddCustomer(customer);
        customerProductService.checkAddCustomer(customer1);
        customerProductService.checkAddProduct(product);
        customerProductService.checkAddProduct(product1);
        customerProductService.checkGetCustomersByProductId(1);
    }
}
