package com.epam.laboratory.aircompany.aiports;
import com.epam.laboratory.aircompany.planes.Plane;

import java.util.Comparator;
import java.util.List;

abstract public class Airport {
    public Airport(List<? extends Plane> planesList) {
        this.PLANES = planesList;
    }

    private final List<? extends Plane> PLANES;

    public Airport sortPlanesByMaxDistance() {
        PLANES.sort((Comparator<Plane>) (o1, o2) -> o1.getMaxFlightDistance() - o2.getMaxFlightDistance());
        return this;
    }

    public Airport sortPlanesByMaxSpeed() {
        PLANES.sort((Comparator<Plane>) (o1, o2) -> o1.getMaxSpeed() - o2.getMaxSpeed());
        return this;
    }

    public void sortPlanesByMaxLoadCapacity() {
        PLANES.sort((Comparator<Plane>) (p1, p2) -> p1.getMaxLoadCapacity() - p2.getMaxLoadCapacity());
    }

    public List<? extends Plane> getPlanesList() {
        return PLANES;
    }


    public abstract Plane getPlaneWithMaxCapacity();
}
