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
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        MilitaryPlane planeWithMaxCapacity = militaryPlanes.get(0);
        for (MilitaryPlane militaryPlane : militaryPlanes) {
            if (militaryPlane.getMaxLoadCapacity() > planeWithMaxCapacity.getMaxLoadCapacity()) {
                planeWithMaxCapacity = militaryPlane;
            }
        }
        return planeWithMaxCapacity;
    }


    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : MILITARY_PLANES) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : MILITARY_PLANES) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }


    private List<MilitaryPlane> getPlanesByMilitaryType(MilitaryType type) {
        List<MilitaryPlane> planesOfSpecifiedType = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
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