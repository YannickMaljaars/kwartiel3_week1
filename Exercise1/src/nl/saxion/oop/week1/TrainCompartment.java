package nl.saxion.oop.week1;

import nl.saxion.app.SaxionApp;

public class TrainCompartment {
    private int numberOfSeats;
    private int compartmentClass;
    private int numberOfSeatsInUse;

    public TrainCompartment(int numberOfSeats, int numberOfSeatsInUse, int compartmentClass) {
        if (numberOfSeats == 0) {
            SaxionApp.printLine("Error!");
        } else {
            this.numberOfSeats = numberOfSeats;
        }

        if (numberOfSeatsInUse == 0) {
            SaxionApp.printLine("Error!");
        } else {
            this.numberOfSeatsInUse = numberOfSeatsInUse;
        }

        if (compartmentClass == 0) {
            SaxionApp.printLine("Error!");
        } else {
            this.compartmentClass = compartmentClass;
        }
    }
    public void enter() {

        if(numberOfSeatsInUse < numberOfSeats) {

            numberOfSeatsInUse++;
            SaxionApp.printLine("A passenger enters the train...");

        } else {

            SaxionApp.printLine("The train is full! Passenger can't enter the train");

        }

        SaxionApp.printLine("There are now " + numberOfSeatsInUse + " seats in use.");

    }
    public void exit() {

        if(numberOfSeatsInUse > 0) {

            numberOfSeatsInUse = numberOfSeatsInUse - 1;
            SaxionApp.printLine("A passenger leaves the train...");

        } else {

            SaxionApp.printLine("The train is empty, there is no one left to leave the train!");

        }

        SaxionApp.printLine("There are now " + numberOfSeatsInUse + " seats in use.");
    }
    public int getNumberOfSeats() {
        return numberOfSeats;
    }
    public int getNumberOfSeatsInUse() {
        return numberOfSeatsInUse;
    }
    public int getCompartmentClass() {
        return compartmentClass;
    }
    public void showTrainCompartment() {
        SaxionApp.print("There are currently " + numberOfSeatsInUse + " seats in use ");
        SaxionApp.print("out of a total of " + numberOfSeats + " on the train ");
        SaxionApp.print("compartment with class " + compartmentClass + ".");
    }
}