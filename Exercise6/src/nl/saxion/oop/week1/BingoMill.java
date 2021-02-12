package nl.saxion.oop.week1;


import nl.saxion.app.SaxionApp;

import java.util.ArrayList;
import java.util.Collections;

public class BingoMill {

    private ArrayList<Integer> numbers = new ArrayList<>();

    public BingoMill(){
        for (int i = 0; i < 75; i++) {
            numbers.add(i+1);
        }
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public int draw() {
        if (numbers.size() < 1) {
            return -1;
        } else {
            return numbers.remove(0);
        }
    }

    public int getNumberOfBallsRemaining() {
        return numbers.size();
    }

    public void reset(){
        numbers.clear();
        for (int i = 0; i < 75; i++) {
            numbers.add(i+1);
        }
        shuffle();
    }

    public void shuffle(){
        for (int i = 0; i < 500; i++) {
            int a = SaxionApp.getRandomValueBetween(0,75);
            int b = SaxionApp.getRandomValueBetween(0,75);
            Collections.swap(numbers, a, b);
        }

    }
}
