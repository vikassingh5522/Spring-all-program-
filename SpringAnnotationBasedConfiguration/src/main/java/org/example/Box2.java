package org.example;


import org.springframework.stereotype.Component;

@Component("box2")
public class Box2 extends MyBox {
    public Box2() {
        super(5); // Calls MyBox(double t) constructor
    }
}