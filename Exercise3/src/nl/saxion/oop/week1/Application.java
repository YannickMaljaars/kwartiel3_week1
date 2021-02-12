package nl.saxion.oop.week1;

import nl.saxion.app.SaxionApp;
import java.lang.Math.*;

import static java.lang.Math.*;


public class Application implements Runnable {
    public static void main(String[] args) {
        SaxionApp.start(new Application());
    }

    public void run() {

        Circle c = new Circle(250,250,100);

        SaxionApp.printLine("x: " + c.getX() + ", y: " + c.getY() + ", radius: " + c.getRadius());
        SaxionApp.printLine("area: " + c.area() + ", perimeter: " + c.perimeter());


        c.draw();

    }
}