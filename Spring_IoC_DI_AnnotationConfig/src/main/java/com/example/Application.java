package com.example;

import com.example.config.AppConfig;
import com.example.service.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        // Initialize Spring context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get CustomerService bean
        CustomerService customerService = context.getBean(CustomerService.class);

        // Test all injection types
        System.out.println("Field Injection: " + customerService.getCustomerByIdUsingFieldInjection(1L));
        System.out.println("Constructor Injection: " + customerService.getCustomerByIdUsingConstructorInjection(2L));
        System.out.println("Setter Injection: " + customerService.getCustomerByIdUsingSetterInjection(3L));

        // Close context
        context.close();
    }
}