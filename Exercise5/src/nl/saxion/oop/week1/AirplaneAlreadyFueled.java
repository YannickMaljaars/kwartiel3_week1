package nl.saxion.oop.week1;

public class AirplaneAlreadyFueled extends RuntimeException{
    public AirplaneAlreadyFueled() {
        super ("Airplane is already fueled");
    }
}
