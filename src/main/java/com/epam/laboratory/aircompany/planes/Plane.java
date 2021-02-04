package com.epam.laboratory.aircompany.planes;

import java.util.Objects;

abstract public class Plane {
    final private String MODEL;
    final private int MAX_SPEED;
    final private int MAX_FLIGHT_DISTANCE;
    final private int MAX_LOAD_CAPACITY;

    public Plane(String MODEL, int MAX_SPEED, int MAX_FLIGHT_DISTANCE, int MAX_LOAD_CAPACITY) {
        this.MODEL = MODEL;
        this.MAX_SPEED = MAX_SPEED;
        this.MAX_FLIGHT_DISTANCE = MAX_FLIGHT_DISTANCE;
        this.MAX_LOAD_CAPACITY = MAX_LOAD_CAPACITY;
    }

    public String getModel() {
        return MODEL;
    }

    public int getMaxSpeed() {
        return MAX_SPEED;
    }

    public int getMaxFlightDistance() {
        return MAX_FLIGHT_DISTANCE;
    }

    public int getMaxLoadCapacity() {
        return MAX_LOAD_CAPACITY;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + MODEL + '\'' +
                ", maxSpeed=" + MAX_SPEED +
                ", maxFlightDistance=" + MAX_FLIGHT_DISTANCE +
                ", maxLoadCapacity=" + MAX_LOAD_CAPACITY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return MAX_SPEED == plane.MAX_SPEED &&
                MAX_FLIGHT_DISTANCE == plane.MAX_FLIGHT_DISTANCE &&
                MAX_LOAD_CAPACITY == plane.MAX_LOAD_CAPACITY &&
                Objects.equals(MODEL, plane.MODEL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MODEL, MAX_SPEED, MAX_FLIGHT_DISTANCE, MAX_LOAD_CAPACITY);
    }

}
