package org.example;




import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("box4")
public class Box4 extends MyBox {
    @Value("6")
    private double len;
    @Value("3")
    private double wid;
    @Value("4")
    private double hig;

    // Override setters to use the injected values
    @Override
    public void setLen(double len) {
        this.len = len;
    }

    @Override
    public void setWid(double wid) {
        this.wid = wid;
    }

    @Override
    public void setHig(double hig) {
        this.hig = hig;
    }
}