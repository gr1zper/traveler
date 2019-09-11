package org.app.model.entity.geography;

import org.app.module.entity.geography.City;
import org.app.module.entity.geography.Station;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Contains unit-tests to check functionality of {@link City} class
 * @author avzubkov
 */
public class CityTest {
    @Test
    public void testAddValidStationSuccess() {
        Station station = new Station();
        City city = new City();
        city.addStation(station);

        assertTrue(containsStation(city, station));
    }

    private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }

}
