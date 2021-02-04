package com.epam.laboratory;

import com.epam.laboratory.aircompany.aiports.*;
import com.epam.laboratory.aircompany.planes.*;
import com.epam.laboratory.aircompany.planes.types.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AirportTest {

    private static final List<Plane> passengerPlanes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196)
    );
    PassengerAirport passengerAirport = new PassengerAirport(passengerPlanes);

    private static final List<Plane> militaryPlanes = Arrays.asList(
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VERTICAL_TAKE_OFF_AND_LANDING, ClassificationLevel.TOP_SECRET)
    );
    MilitaryAirport militaryAirport = new MilitaryAirport(militaryPlanes);

    private static final PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);


    public boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent(List<? extends Plane> planesSortedByMaxLoadCapacity) {
        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            if (planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity()
                    > planesSortedByMaxLoadCapacity.get(i + 1).getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        return nextPlaneMaxLoadCapacityIsHigherThanCurrent;
    }


    @Test
    public void testGetTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = militaryAirport.getTransportMilitaryPlanes();
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            Assert.assertEquals(militaryPlane.getMilitaryType(), MilitaryType.TRANSPORT);
        }
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = passengerAirport.getPlaneWithMaxPassengerCapacity();
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortMilitaryPlanesByMaxLoadCapacity() {
        militaryAirport.sortPlanesByMaxLoadCapacity();
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent(militaryAirport.getMilitaryPlanes()));
    }

    @Test
    public void testSortPassengerPlanesByMaxLoadCapacity() {
        passengerAirport.sortPlanesByMaxLoadCapacity();
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent(passengerAirport.getPassengerPlanes()));
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = militaryAirport.getBomberMilitaryPlanes();
        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
            Assert.assertEquals(militaryPlane.getMilitaryType(), MilitaryType.BOMBER);
        }
    }

    @Test
    public void testExperimentalPlanesHasNonUnclassifiedClassificationLevel() {
        List<ExperimentalPlane> experimentalPlanes = militaryAirport.getExperimentalPlanes();
        for (ExperimentalPlane experimentalPlane : experimentalPlanes) {
            Assert.assertEquals(experimentalPlane.getClassificationLevel(), ClassificationLevel.UNCLASSIFIED);
        }
    }
}
