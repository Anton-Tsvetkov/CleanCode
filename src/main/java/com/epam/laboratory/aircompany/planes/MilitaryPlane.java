package com.epam.laboratory.aircompany.planes;

import com.epam.laboratory.aircompany.planes.types.*;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private final MilitaryType MILITARY_TYPE;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryType militaryType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.MILITARY_TYPE = militaryType;
    }

    public MilitaryType getMilitaryType() {
        return MILITARY_TYPE;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", militaryType=" + MILITARY_TYPE +
                        '}');
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MilitaryPlane)) return false;
        if (!super.equals(o)) return false;
        MilitaryPlane that = (MilitaryPlane) o;
        return MILITARY_TYPE == that.MILITARY_TYPE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), MILITARY_TYPE);
    }
}