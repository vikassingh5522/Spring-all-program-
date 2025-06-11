package com.example.service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    // Field Injection
    @Autowired
    private CustomerRepository fieldRepository;

    // Constructor Injection
    private final CustomerRepository constructorRepository;

    // Setter Injection
    private CustomerRepository setterRepository;

    @Autowired
    public CustomerService(CustomerRepository constructorRepository) {
        this.constructorRepository = constructorRepository;
    }

    @Autowired
    public void setSetterRepository(CustomerRepository setterRepository) {
        this.setterRepository = setterRepository;
    }

    public Customer getCustomerByIdUsingFieldInjection(Long id) {
        return fieldRepository.findCustomerById(id);
    }

    public Customer getCustomerByIdUsingConstructorInjection(Long id) {
        return constructorRepository.findCustomerById(id);
    }

    public Customer getCustomerByIdUsingSetterInjection(Long id) {
        return setterRepository.findCustomerById(id);
    }
}