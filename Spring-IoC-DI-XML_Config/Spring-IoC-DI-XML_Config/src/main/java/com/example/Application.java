package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        // Create IoC container
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MessagePrinter printer = context.getBean("messagePrinter",MessagePrinter.class);
        printer.printMessage(); // Output: Hello from XML!
    }
}