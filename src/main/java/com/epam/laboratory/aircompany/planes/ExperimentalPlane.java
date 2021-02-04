package com.epam.laboratory.aircompany.planes;

import com.epam.laboratory.aircompany.planes.types.*;

public class ExperimentalPlane extends Plane {

    private final ExperimentalType EXPERIMENTAL_TYPE;
    private final ClassificationLevel CLASSIFICATION_LEVEL;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalType experimentalType, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.EXPERIMENTAL_TYPE = experimentalType;
        this.CLASSIFICATION_LEVEL = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return CLASSIFICATION_LEVEL;
    }

    public ExperimentalType getExperimentalType() {
        return EXPERIMENTAL_TYPE;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }
}
