package com.example.repository;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    public Customer findCustomerById(Long id) {
        // Simulate database access
        return new Customer(id, "Customer_" + id);
    }
}