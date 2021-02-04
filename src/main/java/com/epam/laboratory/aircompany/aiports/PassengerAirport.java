package com.epam.laboratory.aircompany.aiports;

import com.epam.laboratory.aircompany.planes.*;

import java.util.ArrayList;
import java.util.List;

public class PassengerAirport extends Airport {

    private final List<? extends Plane> PASSENGER_PLANES;

    public PassengerAirport(List<? extends Plane> planesList) {
        super(planesList);
        this.PASSENGER_PLANES = planesList;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlaneList = new ArrayList<>();
        for (Plane plane : this.PASSENGER_PLANES) {
            if (plane instanceof PassengerPlane) {
                passengerPlaneList.add((PassengerPlane) plane);
            }
        }
        return passengerPlaneList;
    }


    public PassengerPlane getPlaneWithMaxPassengerCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxPassengerCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxPassengerCapacity.getPassengersCapacity()) {
                planeWithMaxPassengerCapacity = passengerPlane;
            }
        }
        return planeWithMaxPassengerCapacity;
    }

    public PassengerPlane getPlaneWithMaxCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getMaxLoadCapacity() > planeWithMaxCapacity.getMaxLoadCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    @Override
    public String toString() {
        return "PassengerAirport{" +
                "passengersPlanes=" + PASSENGER_PLANES +
                '}';
    }
}
