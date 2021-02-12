package nl.saxion.oop.week1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import static org.junit.jupiter.api.Assertions.*;

class AirplaneTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void itDepartsWhenReady() {
        Airplane plane = new Airplane();
        plane.fuel();
        plane.loadPassengers();
        plane.loadLuggage();
        plane.lockDoors();
        plane.depart();
        assertTrue(plane.hasDeparted(), "Plane shan't depart");
    }

    @Test
    void itRefusesToDepartWithoutLuggage() {
        Airplane plane = new Airplane();
        plane.fuel();
        plane.loadPassengers();
        plane.lockDoors();
        this.assertThrows(AirplaneDepartureException.noLuggageLoaded(), plane::depart);
    }

    @Test
    void itRefusesToDepartWithoutLockedDoors() {
        Airplane plane = new Airplane();
        plane.fuel();
        plane.loadPassengers();
        plane.loadLuggage();
        this.assertThrows(AirplaneDepartureException.doorsNotLocked(), plane::depart);
    }


    @Test
    void failedToLockDoors() {
        Airplane plane = new Airplane();
        plane.lockDoors();
        Assertions.assertThrows(AirplaneLockedPrematurelyException.class, plane::loadPassengers);
    }

    @Test
    void itRefusesToDepartWithoutPassengers() {
        Airplane plane = new Airplane();
        plane.fuel();
        plane.loadLuggage();
        plane.lockDoors();
        this.assertThrows(AirplaneDepartureException.noPassengersLoaded(), plane::depart);
    }

    @Test
    void doorsCanBeLocked() {
        Airplane plane = new Airplane();
        plane.lockDoors();
        assertTrue(plane.isLocked());
    }

    @Test
    void doorsCanBeUnlocked() {
        Airplane plane = new Airplane();
        plane.unlockDoors();
        assertFalse(plane.isLocked());
    }

    @Test
    void itIsNotDepartedByDefault() {
        Airplane plane = new Airplane();
        assertFalse(plane.hasDeparted(), "Plane departed immediately");
    }

    @Test
    void luggageCanBeLoaded() {
        Airplane plane = new Airplane();
        plane.loadLuggage();
        assertTrue(plane.luggageIsLoaded(), "Plane did not load luggage");
    }
    @Test
    void luggageCannotBeLoadedWhenDoorsAreLocked() {
        Airplane plane = new Airplane();
        plane.lockDoors();
        Assertions.assertThrows(AirplaneLockedPrematurelyException.class, plane::loadLuggage);
    }

    @Test
    void itCanBeFueled() {
        Airplane plane = new Airplane();
        plane.fuel();
        assertTrue(plane.isFueled(), "Plane did not get fueled");
    }

    @Test
    void itCannotBeFueledWhenAlreadyFueled() {
        Airplane plane = new Airplane();
        plane.fuel();
        Assertions.assertThrows(AirplaneAlreadyFueled.class, plane::fuel);
    }

    private void assertThrows(Exception expected, Executable executable) {
        Exception actual = Assertions.assertThrows(Exception.class, executable);
        Assertions.assertEquals(expected.getMessage(), actual.getMessage());
    }



}