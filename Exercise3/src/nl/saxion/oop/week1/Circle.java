package nl.saxion.oop.week1;
import nl.saxion.app.SaxionApp;

import java.lang.Math;

public class Circle {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public double area() {
        return (Math.PI * radius * radius);
    }

    public double perimeter() {
        return (2*Math.PI*radius);
    }

    public void draw(){
        SaxionApp.turnBorderOff();
        SaxionApp.setFill(SaxionApp.SAXION_PINK);
        SaxionApp.drawCircle(x, y, radius);
    }
}
