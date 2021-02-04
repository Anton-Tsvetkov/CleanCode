package com.epam.laboratory.aircompany.planes;

import java.util.Objects;

public class PassengerPlane extends Plane {

    private final int PASSENGERS_CAPACITY;

    public PassengerPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, int PASSENGERS_CAPACITY) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.PASSENGERS_CAPACITY = PASSENGERS_CAPACITY;
    }


    public int getPassengersCapacity() {
        return PASSENGERS_CAPACITY;
    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                "PASSENGERS_CAPACITY=" + PASSENGERS_CAPACITY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PassengerPlane)) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;
        return PASSENGERS_CAPACITY == plane.PASSENGERS_CAPACITY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), PASSENGERS_CAPACITY);
    }
}
