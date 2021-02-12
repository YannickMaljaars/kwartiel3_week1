package nl.saxion.oop.week1;

public class PlaneAlreadyDepartedException extends AirplaneDepartureException {
    public PlaneAlreadyDepartedException(){
        super ("Plane has already departed");
    }
}
