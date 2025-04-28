package org.app.model.entity.geography;

import org.app.model.entity.transport.TransportType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Contains unit-tests to check functionality of {@link City} class
 *
 * @author avzubkov
 */
public class CityTest {

    private static City city;

    @BeforeAll
    static void setup() {
        city = new City("London");
    }

    @Test
    public void testAddValidStationSuccess() {
        Station station = city.addStation(TransportType.AUTO);
        assertTrue(containsStation(city, station));
        assertEquals(city, station.getCity());
    }

    @Test
    public void testAddNullStationFailure() {
        assertThrows(NullPointerException.class, () -> city.addStation(null));
    }

    @Test
    public void testRemoveStationSuccess() {
        Station station = city.addStation(TransportType.AVIA);
        city.removeStation(station);
        assertTrue(city.getStations().isEmpty());
    }

    @Test
    public void testRemoveNullStationFailure() {
        assertThrows(NullPointerException.class, () -> city.removeStation(null));
    }

    private boolean containsStation(City city, Station station) {
        return city.getStations().contains(station);
    }

}
