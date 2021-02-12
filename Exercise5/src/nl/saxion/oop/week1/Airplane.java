package nl.saxion.oop.week1;

import nl.saxion.app.SaxionApp;

public class Airplane {

    private boolean passengersLoaded = false;
    private boolean luggageLoaded = false;
    private boolean doorsLocked = false;
    private boolean departed = false;
    private boolean fueled = false;

    public boolean passengersAreLoaded() {
        return passengersLoaded;
    }

    public boolean luggageIsLoaded() {
        return luggageLoaded;
    }

    public void loadPassengers() {
        ensureDoorsAreUnlocked();
        passengersLoaded = true;
    }

    public void loadLuggage() {
        ensureDoorsAreUnlocked();
        luggageLoaded = true;
    }

    public void lockDoors() {
        doorsLocked = true;
    }

    public void unlockDoors() {
        doorsLocked = false;
    }

    public boolean isLocked() {
        return doorsLocked;
    }

    public void depart() {
        if (hasDeparted()){
            throw new PlaneAlreadyDepartedException();
        }
        if (!passengersAreLoaded()) {
            throw AirplaneDepartureException.noPassengersLoaded();
        }
        if (!luggageIsLoaded()) {
            throw AirplaneDepartureException.noLuggageLoaded();
        }
        if (!isLocked()) {
            throw AirplaneDepartureException.doorsNotLocked();
        }
        departed = true;
    }

    public boolean hasDeparted() {
        return departed;
    }

    private void ensureDoorsAreUnlocked() {
        if (doorsLocked) {
            throw new AirplaneLockedPrematurelyException();
        }
    }

    public void fuel() {
        if (isFueled()) {
            throw new AirplaneAlreadyFueled();
        }
        fueled = true;

    }

    public boolean isFueled() {
        return fueled;
    }
}
