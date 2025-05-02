package service.transform.impl;

import org.app.infra.exception.flow.InvalidParameterException;
import org.app.model.entity.geography.City;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rest.dto.CityDto;
import service.transform.Transformer;

import static org.junit.jupiter.api.Assertions.*;

class SimpleDtoTransformerTest {

    private static Transformer transformer;

    @BeforeAll
    public static void setup() {
        transformer = new SimpleDtoTransformer();
    }

    @Test
    void testTransformCitySuccess() {
        var city = new City("London");
        city.setId(1);
        city.setRegion("Lond");
        city.setDistrict("None");

        var dto = transformer.transform(city, CityDto.class);
        assertNotNull(dto);
        assertEquals(dto.getId(), city.getId());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test
    void testTransformNullCityFailure() {
        assertThrows(
                InvalidParameterException.class,
                () -> transformer.transform(null, CityDto.class)
        );
    }

    @Test
    void testTransformNullDTOClassFailure() {
        assertThrows(
                InvalidParameterException.class,
                () -> transformer.transform(new City("London"), null)
        );
    }

    @Test
    void testUnTransformCitySuccess() {
        var dto = new CityDto();
        dto.setId(1);
        dto.setRegion("Lond");
        dto.setDistrict("None");
        dto.setName("London");

        var city = transformer.untransform(dto, City.class);
        assertNotNull(city);
        assertEquals(dto.getId(), city.getId());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test
    void testUnTransformNullCityFailure() {
        assertThrows(
                InvalidParameterException.class,
                () -> transformer.untransform(null, City.class)
        );
    }

    @Test
    void testUnTransformNullEntityClassFailure() {
        assertThrows(
                InvalidParameterException.class,
                () -> transformer.untransform(new CityDto(), null)
        );
    }
}