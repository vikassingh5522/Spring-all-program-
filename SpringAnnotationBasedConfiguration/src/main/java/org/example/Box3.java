package org.example;


import org.springframework.stereotype.Component;

@Component("box3")
public class Box3 extends MyBox {
    public Box3() {
        super(3, 4, 5); // Calls MyBox(double a, double b, double c) constructor
    }
}