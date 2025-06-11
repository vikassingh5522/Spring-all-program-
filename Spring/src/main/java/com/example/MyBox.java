package com.example;

public class MyBox {
    private double len;
    private double wid;
    private double hig;

    // ------- Constructors ---------
    public MyBox() {
        len = 1;
        wid = 1;
        hig = 1;
    }

    public MyBox(double t) {
        len = t;
        wid = t;
        hig = t;
    }

    public MyBox(double a, double b, double c) {
        len = a;
        wid = b;
        hig = c;
    }

    // ----------- Getter Methods ------------
    public double getLen() {
        return len;
    }

    public double getWid() {
        return wid;
    }

    public double getHig() {
        return hig;
    }

    // ----------- Setter Methods ------------
    public void setLen(double len) {
        this.len = len;
    }

    public void setWid(double wid) {
        this.wid = wid;
    }

    public void setHig(double hig) {
        this.hig = hig;
    }

    // ----------- Volume Method ------------
    public void volume() {
        System.out.println("Box volume: " + (len * wid * hig));
    }
}