package nl.saxion.oop.week1;

public class AirplaneDepartureException extends RuntimeException{

    public AirplaneDepartureException(String message) {
        super(message);
    }

    public static AirplaneDepartureException doorsNotLocked() {
        return new AirplaneDepartureException("Doors are not locked");
    }
    public static AirplaneDepartureException noPassengersLoaded() {
        return new AirplaneDepartureException("No passengers were loaded");
    }
    public static AirplaneDepartureException noLuggageLoaded() {
        return new AirplaneDepartureException("No luggage was loaded");
    }

}
