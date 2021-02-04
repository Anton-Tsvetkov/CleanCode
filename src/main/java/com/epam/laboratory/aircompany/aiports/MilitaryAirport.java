package com.epam.laboratory.aircompany.aiports;

import com.epam.laboratory.aircompany.planes.*;
import com.epam.laboratory.aircompany.planes.types.*;

import java.util.ArrayList;
import java.util.List;

public class MilitaryAirport extends Airport {

    private final List<? extends Plane> MILITARY_PLANES;

    public MilitaryAirport(List<? extends Plane> planesList) {
        super(planesList);
        this.MILITARY_PLANES = planesList;
    }

    @Override
    public Plane getPlaneWithMaxCapacity() {
        List<MilitaryPlane> militaryPlanes = (List<MilitaryPlane>) getMilitaryPlanes();
        MilitaryPlane planeWithMaxCapacity = militaryPlanes.get(0);
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getMaxLoadCapacity() > planeWithMaxCapacity.getMaxLoadCapacity()) {
                planeWithMaxCapacity = militaryPlane;
            }
        }
        return planeWithMaxCapacity;
    }


    private List<? extends Plane> getSomePlanes(Class<? extends Plane> somePlane) {
        List<Plane> planes = new ArrayList<>();
        for (Plane plane : MILITARY_PLANES) {
            if (plane.getClass() == somePlane) {
                planes.add(plane);
            }
        }
        return planes;
    }


    public List<? extends Plane> getMilitaryPlanes() {
        return getSomePlanes(MilitaryPlane.class);
    }

    public List<? extends Plane> getExperimentalPlanes() {
        return getSomePlanes(ExperimentalPlane.class);
    }


    private List<MilitaryPlane> getPlanesByMilitaryType(MilitaryType type) {
        List<MilitaryPlane> planesOfSpecifiedType = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = (List<MilitaryPlane>) getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getMilitaryType() == type) {
                planesOfSpecifiedType.add(plane);
            }
        }
        return planesOfSpecifiedType;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        return getPlanesByMilitaryType(MilitaryType.TRANSPORT);
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        return getPlanesByMilitaryType(MilitaryType.BOMBER);
    }


    @Override
    public String toString() {
        return "MilitaryAirport{" +
                "militaryPlanes=" + MILITARY_PLANES +
                '}';
    }
}