package nl.saxion.oop.week1;

import nl.saxion.app.SaxionApp;

import java.awt.*;

public class Car {
    private String brand;
    private String licensePlate;
    private int tankSize;
    private int tankStance;
    private final int fuelConsumption;
    private int mileage; //in kilometers;


    public Car(String brand, String licensePlate, int tankSize, int fuelConsumption) {
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.tankSize = tankSize;
        this.fuelConsumption = fuelConsumption;

        this.tankStance = tankSize;
        this.mileage = 0;
    }

    public void drive(int km){
        mileage = mileage + km;
        int newStance = tankStance - (km/fuelConsumption);
        if(newStance < 0) {
            SaxionApp.printLine("You can't drive that far, you don't have enough fuel!", Color.red);
        }else if (newStance == 0) {
            tankStance = newStance;
            SaxionApp.printLine("You have driven " + km + " kilometers, you're tank stance is now " + tankStance + "/" + tankSize, Color.green);
            SaxionApp.printLine("Your car is out of fuel, please refuel if you want to drive more!", Color.red);
        }else {
            tankStance = newStance;
            SaxionApp.printLine("You have driven " + km + " kilometers, you're tank stance is now " + tankStance + "/" + tankSize, Color.green);
        }
    }
    public void fuel(int liters){
        if ((liters + tankStance) <= tankSize) {
            tankStance = tankStance + liters;
            SaxionApp.printLine("You have filled the tank for " + liters + " liters, the current tank stance is now " + tankStance + "/" + tankSize, Color.green);
        } else {
            SaxionApp.printLine("You cant overfill the tank!", Color.red);
        }
    }

    @Override
    public String toString() {
        return brand + " (" + licensePlate + "), tank fullness: (" + tankStance + "/" + tankSize + "), mileage in km: (" + mileage + ").";
    }

    //Getters
    public int getFuelConsumption() {
        return fuelConsumption;
    }public int getMileage() {
        return mileage;
    }public int getTankSize() {
        return tankSize;
    }
    public int getTankStance() {
        return tankStance;
    }public String getBrand() {
        return brand;
    }public String getLicensePlate() {
        return licensePlate;
    }
    //Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }    public void setTankSize(int tankSize) {
        this.tankSize = tankSize;
    }
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

}
