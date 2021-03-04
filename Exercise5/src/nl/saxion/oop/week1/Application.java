package nl.saxion.oop.week1;

import nl.saxion.app.SaxionApp;

import java.awt.*;

public class Application implements Runnable {

    private Airplane plane;

    public static void main(String[] args) {
        SaxionApp.start(new Application());
    }

    public void run() {
        // TEST - Scenario 1: The successful way
        // plane.loadPassengers();
        // plane.loadLuggage();
        // plane.lockDoors();
        // plane.depart();

        // TEST - Scenario 2: Failure due to locked doors
        // plane.lockDoors();
        // plane.loadPassengers(); <-- This should result in a print stating that we cannot depart!

        // TEST - Scenario 3: Failure due to not loading passengers
        // plane.loadLuggage();
        // plane.lockDoors();
        // plane.depart(); <-- This should result in a print stating that we cannot depart!

        plane = new Airplane();
        while(true){

            SaxionApp.clear();
            SaxionApp.printLine("****** Aircraft preparation terminal ******");
            SaxionApp.printLine("* 1) Load passengers");
            SaxionApp.printLine("* 2) Load luggage");
            SaxionApp.printLine("* 3) Lock/Unlock doors ");
            SaxionApp.printLine("* 4) Fuel plane");
            SaxionApp.printLine("* 9) Depart ");
            SaxionApp.printLine("* 0) Exit!");
            SaxionApp.printLine("***************************************");

            SaxionApp.print("Please make a selection from the menu: ");
            int menuInput = SaxionApp.readInt();


            if (menuInput == 0){
                break;
            }

            SaxionApp.printLine();
            handleMenuInput(menuInput);
            SaxionApp.pause();

        }

    }

    private void handleMenuInput(int menuInput) {
        switch (menuInput) {
            case 1:
                loadPassengers();
                break;

            case 2:
                loadLuggage();
                break;

            case 3:
                toggleDoorLock();
                break;

            case 4:
                fuelPlane();

            case 9:
                departPlane();
                break;

            default:
                SaxionApp.printLine("Invalid input", Color.orange);
        }
    }

    private void fuelPlane() {
        try {
            plane.fuel();
            SaxionApp.printLine("Airplane fueled", Color.green);
        } catch (AirplaneAlreadyFueled e) {
            SaxionApp.printLine(e.getMessage(), Color.red);
        }

    }

    private void departPlane() {
        try {
            plane.depart();
            SaxionApp.printLine("Plane departing.......zoef zoef", Color.green);
        } catch (AirplaneDepartureException exception) {
            SaxionApp.printLine(exception.getMessage(), Color.red);
        }
    }

    private void toggleDoorLock() {
        if (plane.isLocked()) {
            plane.unlockDoors();
            SaxionApp.printLine("Doors are unlocked!", Color.green);
        } else {
            plane.lockDoors();
            SaxionApp.printLine("Doors are locked!", Color.green);
        }
    }

    private void loadLuggage() {
        if (plane.luggageIsLoaded()) {
            SaxionApp.printLine("Luggage already loaded", Color.red);
            return;
        }
        try {
            plane.loadLuggage();
            SaxionApp.printLine("Luggage loaded", Color.green);
        } catch (AirplaneLockedPrematurelyException e) {
            SaxionApp.printLine("Luggage could not enter plane", Color.red);
        }
    }

    private void loadPassengers() {
        if (plane.passengersAreLoaded()) {
            SaxionApp.printLine("Passengers already loaded", Color.red);
            return;
        }
        try {
            plane.loadPassengers();
            SaxionApp.printLine("Passengers loaded", Color.green);
        } catch (AirplaneLockedPrematurelyException e) {
            SaxionApp.printLine("Passengers could not enter plane", Color.red);
        }
    }

}
