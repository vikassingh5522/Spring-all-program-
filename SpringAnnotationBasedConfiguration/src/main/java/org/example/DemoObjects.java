package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class DemoObjects {
    public static void main(String[] args) {
        // Load the Spring application context with component scanning
        ApplicationContext context = new AnnotationConfigApplicationContext(DemoObjects.class);

        // Retrieve and use box1 (default constructor)
        MyBox b1 = context.getBean("box1", MyBox.class);
        b1.volume();

        // Retrieve and use box2 (single parameter constructor)
        MyBox b2 = context.getBean("box2", MyBox.class);
        b2.volume();

        // Retrieve and use box3 (three parameter constructor)
        MyBox b3 = context.getBean("box3", MyBox.class);
        b3.volume();

        // Retrieve and use box4 (setter-based configuration)
        MyBox b4 = context.getBean("box4", MyBox.class);
        b4.volume();

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}