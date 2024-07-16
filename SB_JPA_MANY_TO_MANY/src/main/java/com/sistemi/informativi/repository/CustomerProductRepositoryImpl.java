package com.sistemi.informativi.repository;

import com.sistemi.informativi.entity.Customer;
import com.sistemi.informativi.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class CustomerProductRepositoryImpl implements CustomerProductRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCustomer(Customer customer) {
        em.persist(customer);
    }

    @Override
    public void addProduct(Product product) {
        em.persist(product);
    }

    @Override
    public List<Customer> getCustomersByProductId(int productId) {
        return em.find(Product.class,productId).getCustomerList();
    }
}
