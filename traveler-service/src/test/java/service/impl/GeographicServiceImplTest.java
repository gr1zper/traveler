package service.impl;

import org.app.model.entity.geography.City;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import service.GeographicService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeographicServiceImplTest {
    private static GeographicService service;

    @BeforeAll
    static void setup() {
        service = new GeographicServiceImpl();
    }

    @Test
    void testSaveNewCitySuccess() {
        City city = new City("London");
        service.saveCity(city);
        List<City> cities = service.findCities();
        assertEquals(1, cities.size());
        assertEquals("London", cities.get(0).getName());
    }
}
